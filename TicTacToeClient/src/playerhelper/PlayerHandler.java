package playerhelper;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import java.util.ArrayList;
import javafx.application.Platform;
import tictactoeclient.Register;
import static tictactoeclient.Register.textUsernameTaken;
import tictactoeclient.SignIn;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import tictactoeclient.ChoosePlayer;

public class PlayerHandler {

    public static DataInputStream ear;
    PrintStream mouth;
    Socket socket;
    Gson gson = new Gson();
    Thread th;
    ArrayList responseData;
    String json;

    public PlayerHandler() {

        try {
            socket = new Socket("127.0.0.1", 5010);
            ear = new DataInputStream(socket.getInputStream());
            mouth = new PrintStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(PlayerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        th = new Thread() {
            public void run() {
                while (true) {
                    try {
                        String json = ear.readLine();
                        responseData = gson.fromJson(json, ArrayList.class);
                        double key = (double) responseData.get(0);
                        if (key == 1) {
                            Platform.runLater(new Runnable() {
                                public void run() {
                                    Register.trueRegister();
                                }

                            });

                        }
                        if (key == 2) {
                            double res = (double) responseData.get(1);
                            if (res == 1) {
                                //ArrayList<PlayerDetails> players;
                                //ArrayList player = gson.fromJson((String) responseData.get(2), ArrayList.class);

                                Type arrayListType = new TypeToken<ArrayList<PlayerDetails>>() {
                                }.getType();

                                // Convert the Gson string to an ArrayList of strings
                                ArrayList<PlayerDetails> players = gson.fromJson((String) responseData.get(2),arrayListType);

                                
                                Platform.runLater(new Runnable() {
                                    public void run() {
                                        SignIn.trueLogin(players);
                                    }

                                });
                            }
                        }
                        if(key==5)
                        {
                            
                            PlayerDetails player = gson.fromJson((String)responseData.get(2), PlayerDetails.class);
                            Platform.runLater(new Runnable() {
                                public void run() {
                                    ChoosePlayer.listPlayers((String)responseData.get(1),player);
                                }

                            });
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(PlayerHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        th.start();
    }

    public void sendRequest(String json) {
        // Send the JSON registration request to ServerHandler
        mouth.println(json);
    }

    public void closeConnection() {
        try {
            th.stop();
            ear.close();
            mouth.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(PlayerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
