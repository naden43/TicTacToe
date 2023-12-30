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
import java.util.Collections;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import tictactoeclient.ChoosePlayer;
import tictactoeclient.Invitation;
import tictactoeclient.OnlineMode;
import tictactoeclient.PlayAgainInvitation;
import tictactoeclient.ProfileHome;
import static tictactoeclient.Register.passFieldPassward;
import static tictactoeclient.Register.txtFieldUserName;

public class PlayerHandler {

    public static DataInputStream ear;
    Alert alert;
    Timeline timeline;
    PrintStream mouth;
    Socket socket;
    static Gson gson = new Gson();
    Thread th;
    //ArrayList responseData;
    static String json;
    public static PlayerDetails playerDetails = null;

    private static List<Object> responseData = Collections.synchronizedList(new ArrayList<>());
    private static final Object lock = new Object();

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
                        synchronized (lock) {
                            responseData = gson.fromJson(json, ArrayList.class);
                            lock.notifyAll();
                        }
                        responseData = gson.fromJson(json, ArrayList.class);
                        double key = (double) responseData.get(0);
                        /*if (key == 1) {
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
                                        //SignIn.trueLogin(players);
                                    }

                                });
                            }
                        }*/
                        if (key == 3) {

                            Platform.runLater(new Runnable() {

                                @Override
                                public void run() {

                                    alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("Invitation");
                                    alert.initOwner(stage);

                                    DialogPane dialogPane = new DialogPane();
                                    dialogPane.setContent(new Invitation(stage, alert, (String) responseData.get(1)));
                                    dialogPane.setPrefSize(400.0, 200.0);

                                    alert.setDialogPane(dialogPane);

                                    timeline = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
                                        alert.close();
                                        alert.setResult(ButtonType.OK);
                                    }));
                                    timeline.setCycleCount(1);

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
                                        stage.setScene(new Scene(new OnlineMode(stage, (String) responseData.get(2), (String) responseData.get(3), (String) responseData.get(4))));
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
                            Type arrayListType = new TypeToken<ArrayList<PlayerDetails>>() {
                            }.getType();
                            ArrayList<PlayerDetails> players = gson.fromJson((String) responseData.get(2), arrayListType);

                            //PlayerDetails player = gson.fromJson((String) responseData.get(2), PlayerDetails.class);
                            Platform.runLater(new Runnable() {
                                public void run() {
                                    ChoosePlayer.listPlayers(players, (String) responseData.get(2));
                                }

                            });
                        }

                        if (key == 6) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    OnlineMode.putTheCharPlay((double) responseData.get(1));
                                }
                            });
                        }
                        if (key == 8) {
                            double playerType = (double) responseData.get(1);
                            if (playerType == 1) {
                                if (OnlineMode.myChar == 'O') {
                                    OnlineMode.score2++;
                                } else {
                                    OnlineMode.score1++;
                                }

                                Type arrayListType = new TypeToken<ArrayList<PlayerDetails>>() {
                                }.getType();
                                ArrayList<PlayerDetails> players = gson.fromJson((String) responseData.get(3), arrayListType);
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        showWinAlert((String) responseData.get(2));
                                        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> OnlineMode.backToChoosePlayer(players)));
                                        timeline.setCycleCount(1);
                                        timeline.play();
                                    }
                                });
                            } else {
                                Type arrayListType = new TypeToken<ArrayList<PlayerDetails>>() {
                                }.getType();
                                ArrayList<PlayerDetails> players = gson.fromJson((String) responseData.get(2), arrayListType);
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        OnlineMode.backToChoosePlayer(players);
                                    }
                                });

                            }

                        }
                        if (key == 10) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    alert = new Alert(Alert.AlertType.INFORMATION);
                                    alert.setTitle("Invitation");
                                    alert.initOwner(stage);

                                    DialogPane dialogPane = new DialogPane();
                                    dialogPane.setContent(new PlayAgainInvitation(stage, alert, (String) responseData.get(1)));
                                    dialogPane.setPrefSize(400.0, 200.0);

                                    alert.setDialogPane(dialogPane);

                                    timeline = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
                                        alert.close();
                                        alert.setResult(ButtonType.OK);
                                    }));
                                    timeline.setCycleCount(1);

                                    alert.show();
                                    timeline.play();
                                }
                            });

                        }
                        if (key == 11) {
                            if (((double) responseData.get(1)) == 1) {

                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        OnlineMode.ResetGame(((double) responseData.get(2)));
                                    }
                                });
                            } else {
                                Platform.runLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        Type arrayListType = new TypeToken<ArrayList<PlayerDetails>>() {
                                        }.getType();
                                        ArrayList<PlayerDetails> players = gson.fromJson((String) responseData.get(2), arrayListType);
                                        OnlineMode.backToChoosePlayer(players);
                                    }
                                });

                            }
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

    public void showWinAlert(String opponent) {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("send invitation");
        alert.setHeaderText(opponent + " left the game and you win");
        //alert.getButtonTypes().clear();
        // Set up a timeline to close the alert after 3 seconds
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> alert.close()));
        timeline.setCycleCount(1); // Run once

        // Show the alert and start the timeline
        alert.show();
        timeline.play();
    }

    public static void RegistrationResponse(Stage stage) {
        synchronized (lock) {
            while (responseData.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            double registrationResult = (double) responseData.get(1);
            if (registrationResult == 1) {
                Platform.runLater(() -> {
                    stage.setScene(new Scene(new SignIn(stage)));
                });
            } else if (registrationResult == 0) {
                userNameExist();
            } else {
                serverFailed();
            }
            responseData.clear();
        }
    }

    public static void loginResponse(Stage stage) {
        synchronized (lock) {
            while (responseData.isEmpty()) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String jsonPlayerDetails = (String) responseData.get(1);

            playerDetails = gson.fromJson(jsonPlayerDetails, PlayerDetails.class);
            Type arrayListType = new TypeToken<ArrayList<PlayerDetails>>() {
            }.getType();
            ArrayList<PlayerDetails> players = gson.fromJson((String) responseData.get(3), arrayListType);
            if (playerDetails != null && !((boolean) responseData.get(2))) {
                Platform.runLater(() -> {
                    stage.setScene(new Scene(new ChoosePlayer(stage, players)));
                    System.out.println(responseData.size() + "size of res");
                });

            } else if (playerDetails != null && ((boolean) responseData.get(2))) {
                Platform.runLater(() -> {
                    SignIn.textUserOrPassWrong.setText("this username is already logged in");
                    SignIn.textUserOrPassWrong.setVisible(true);
                });

            } else if (playerDetails == null) {//incorrect username or password
                System.out.println("playerDetails is null in loginResponse");
                Platform.runLater(() -> {
                    SignIn.textUserOrPassWrong.setText("username or password is incorret");
                    SignIn.textUserOrPassWrong.setVisible(true); //set visible "username or password incorret"
                });
            }
        }
        responseData.clear();
    }

    public static void userNameExist() {
        Platform.runLater(() -> {
            textUsernameTaken.setVisible(true);
            textUsernameTaken.setText("Username already exists");
            txtFieldUserName.setStyle("-fx-border-radius: 50px; -fx-background-radius: 50px;-fx-text-fill: red;");
            passFieldPassward.setText("");
            passFieldPassward.setPromptText("Enter Password");
        });
    }

    public static void serverFailed() {
        Platform.runLater(() -> {
            textUsernameTaken.setVisible(true);
            textUsernameTaken.setText("Server failed. Please try again later");
        });
    }

}
