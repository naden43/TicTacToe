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
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import tictactoeclient.ChoosePlayer;
import tictactoeclient.Invitation;
import tictactoeclient.OnlineMode;

public class PlayerHandler {

    public static DataInputStream ear;
    Alert alert;
    Timeline timeline;
    PrintStream mouth;
    Socket socket;
    Gson gson = new Gson();
    Thread th;
    ArrayList responseData;
    String json;

    public PlayerHandler(Stage stage) {

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
                                ArrayList<PlayerDetails> players = gson.fromJson((String) responseData.get(2), arrayListType);

                                Platform.runLater(new Runnable() {
                                    public void run() {
                                        SignIn.trueLogin(players);
                                    }

                                });
                            }
                        }
                        if (key == 3) {

                            Platform.runLater(new Runnable() {

                                @Override
                                public void run() {

//                                    Stage secondryStage = new Stage();
//                                    secondryStage.initModality(Modality.APPLICATION_MODAL);//blocking                                    
//                                    stage.setScene(null);
//                                    secondryStage.setScene(new Scene(new Invitation(stage, secondryStage)));   
//                                    secondryStage.showAndWait();
                                    alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("Timed Dialog");
                                    //alert.setHeaderText("This dialog will close in 3 seconds.");
                                    alert.initOwner(stage);
                                    alert.getDialogPane().setContent(new Invitation(stage, alert, (String) responseData.get(1)));

                                    // Set up a timeline to close the alert after 3 seconds
                                    timeline = new Timeline(new KeyFrame(Duration.seconds(25), e -> alert.close()));
                                    timeline.setCycleCount(1); // Run once

                                    // Show the alert and start the timeline
                                    alert.show();
                                    timeline.play();
                                }
                            });
                        }

                        if (key == 4) {

                            //System.out.println(responseData.get(1).toString()+"asdy 3leeeeek entaaa");
                            double keyAccept = (double) responseData.get(1);
                            if (keyAccept == 1) {
                               
                                Platform.runLater(new Runnable() {
                                    
                                    public void run() {
                                         if (((String) responseData.get(2)).equals((String) responseData.get(4))) {
                                             ChoosePlayer.closeAlert();
                                         }
                                         stage.setScene(new Scene(new OnlineMode(stage, (String) responseData.get(2), (String) responseData.get(3))));
                                    }
                                });
                            } else if (keyAccept == 0) {
                                Platform.runLater(new Runnable() {

                                    @Override
                                    public void run() {
                                        ChoosePlayer.closeAlert();
                                    }
                                });

                            }

                        }

                        // new player online --> append to my old list
                        if (key == 5) {

                            PlayerDetails player = gson.fromJson((String) responseData.get(2), PlayerDetails.class);
                            Platform.runLater(new Runnable() {
                                public void run() {
                                    ChoosePlayer.listPlayers((String) responseData.get(1), player);
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
