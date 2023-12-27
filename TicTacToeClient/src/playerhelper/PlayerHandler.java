package playerhelper;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tictactoeclient.ProfileHome;
import static tictactoeclient.Register.passFieldPassward;
import static tictactoeclient.Register.textUsernameTaken;
import static tictactoeclient.Register.txtFieldName;
import static tictactoeclient.Register.txtFieldUserName;
import tictactoeclient.SignIn;

public class PlayerHandler {

    DataInputStream ear;
    PrintStream mouth;
    Socket socket;
    Gson gson = new Gson();
    Thread th;
    private static List<Object> responseData = Collections.synchronizedList(new ArrayList<>());
    private static final Object lock = new Object();
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
                        synchronized (lock) {
                            responseData = gson.fromJson(json, ArrayList.class);
                            lock.notifyAll();
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
