 package tictactoeserver;

import database.DatabaseSupplier;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import database.PlayerDetails;
import java.util.ArrayList;

public class ServerHandler {

    DataInputStream ear;
    PrintStream mouth;
    static Vector<ServerHandler> playerList = new Vector<>();
    Gson gson = new Gson();
    DatabaseSupplier databaseSupplier = new DatabaseSupplier();
    Thread th;
    ArrayList requestData;
    ArrayList resultData;
    String UserName ;
    String opponentUser ;
    public ServerHandler(Socket s) {
        try {
            ear = new DataInputStream(s.getInputStream());
            mouth = new PrintStream(s.getOutputStream());
            playerList.add(this);
            th = new Thread() {
                public void run() {
                    while (true) {
                        try {
                            String json = ear.readLine();
             
                            requestData = gson.fromJson(json, ArrayList.class);
                            
                            double key = (double) requestData.get(0);

                            if (key == 1) {
                                registration((String)requestData.get(1));
                            }
                            else if(key==2)
                            {
                                PlayerDetails player = login((String)requestData.get(1));
                                notifyAllUpdate(player);
                            }
                            //login()

                        } catch (IOException ex) {
                            Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
                            break;

                        }

                    }
                }

            };
            th.start();
        } catch (IOException ex) {
            Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void registration(String str) {
        int registrationResult = databaseSupplier.registerPlayer(str);
       
        // send registeration result back to Player handler
        requestData.clear();
        requestData.add(1);
        requestData.add(registrationResult);
        if (registrationResult == 0) {
           requestData.add("Username already exists");
        } else if (registrationResult > 0) {
            requestData.add("Username registered successfully");
        } else {
            requestData.add("Server failed. Please try again later");
        }
        mouth.println(gson.toJson(requestData));
    }
    
    public PlayerDetails login(String str)
    {
        int registrationResult = databaseSupplier.loginPlayer(str);
        resultData = new ArrayList();
        resultData.add(2);
        PlayerDetails playerDetails = gson.fromJson(str, PlayerDetails.class);
        UserName = playerDetails.getUserName();
        System.out.println(UserName);
        resultData.add(registrationResult);
        ArrayList<PlayerDetails> players = databaseSupplier.getOnlineUsers(UserName);
        PlayerDetails player = databaseSupplier.getPlayer(UserName);
        for(int i=0 ;i<players.size();i++)
        {
            System.out.println(players.get(i).getPassword());
        }
        resultData.add(gson.toJson(players));
        System.out.println(resultData.get(1));
        mouth.println(gson.toJson(resultData));
        return player;
    }
    
    synchronized public void notifyAllUpdate(PlayerDetails player)
    {
        for(int i=0 ;i<playerList.size();i++)
        {
            if(playerList.get(i).UserName!=null && !(playerList.get(i).UserName.equals(UserName)))
            {
                ArrayList notify  = new ArrayList();
                notify.add(5);
                notify.add(UserName);
                notify.add(gson.toJson(player));
                playerList.get(i).mouth.println(gson.toJson(notify));
            }
        }
    }

    
}
