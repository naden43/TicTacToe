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
import java.util.ArrayList;

public class ServerHandler {

    DataInputStream ear;
    PrintStream mouth;
    static Vector<ServerHandler> playerList = new Vector<>();
    Gson gson = new Gson();
    DatabaseSupplier databaseSupplier = new DatabaseSupplier();
    Thread th;
    ArrayList requestData;

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
        mouth.println(gson.toJson(requestData));
    }
    

}
