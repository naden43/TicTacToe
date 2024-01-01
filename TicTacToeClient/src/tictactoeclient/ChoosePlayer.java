package tictactoeclient;

import com.google.gson.Gson;
import java.util.ArrayList;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import playerhelper.PlayerDetails;
import playerhelper.PlayerHandler;

public class ChoosePlayer extends ScrollPane {

    protected final AnchorPane anchorPane;
    protected final Text text;
    protected final Text text0;
    protected final Button btnBack;
    protected final Button profilrbtn;
    protected final Text text3;
    static protected final VBox vBox;
    static protected final VBox vBox0;
    static protected final VBox vBox1;
    protected final Button logoutBut;
    protected final Rectangle rectangle;
    protected final Text text1;
    protected final Text text2;
    static Gson gson;
    static ArrayList<Button> buttons;
    static ArrayList<PlayerDetails> players;
    static Alert alert;
    static Timeline timeline;
    protected final ImageView profile;
    

    static {
        vBox = new VBox();
        vBox0 = new VBox();
        vBox1 = new VBox();
        players = new ArrayList<PlayerDetails>();
    }

    public ChoosePlayer(Stage stage) {

        this.players = players;
        gson = new Gson();
        anchorPane = new AnchorPane();
        text = new Text();
        text0 = new Text();
        btnBack = new Button();
        profilrbtn = new Button();
        text3 = new Text();

        logoutBut = new Button();
        buttons = new ArrayList<>();
        rectangle = new Rectangle();
        text1 = new Text();
        text2 = new Text();
        profile = new ImageView();

        this.players = players;
        setContent(anchorPane);
        anchorPane.setStyle("-fx-background-color: #42C4F7;");
        anchorPane.setPrefHeight(500.0);
        anchorPane.setPrefWidth(700.0);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color: #42C4F7;");

        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Text");

        text0.setFill(javafx.scene.paint.Color.WHITE);
        text0.setLayoutX(259.0);
        text0.setLayoutY(49.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Avaliable Players");
        text0.setWrappingWidth(182.11328125);
        text0.setFont(new Font("Berlin Sans FB", 24.0));

        btnBack.setLayoutX(7.0);
        btnBack.setLayoutY(4.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(25.0);
        btnBack.setPrefWidth(22.0);
        btnBack.setStyle("-fx-background-color: #42C4F7;");

        /*profilrbtn.setLayoutX(604.0);
        profilrbtn.setLayoutY(5.0);
        profilrbtn.setMnemonicParsing(false);
        profilrbtn.setPrefHeight(49.0);
        profilrbtn.setPrefWidth(59.0);
        profilrbtn.setStyle("-fx-background-color: #42C4F7;");
        profilrbtn.setFont(new Font("Berlin Sans FB", 18.0));
        */
        rectangle.setArcHeight(55.0);
        rectangle.setArcWidth(55.0);
        rectangle.setFill(javafx.scene.paint.Color.WHITE);
        rectangle.setHeight(300);
        rectangle.setLayoutX(18.0);
        rectangle.setLayoutY(78.0);
        rectangle.setStroke(javafx.scene.paint.Color.WHITE);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(664.0);
        
        profilrbtn.setLayoutX(604.0);
        profilrbtn.setLayoutY(5.0);
        profilrbtn.setMnemonicParsing(false);
        profilrbtn.setPrefHeight(49.0);
        profilrbtn.setPrefWidth(59.0);
        profilrbtn.setStyle("-fx-background-color: #42C4F7;");
        profilrbtn.setFont(new Font("Berlin Sans FB", 18.0));
        profilrbtn.setStyle("-fx-border-color: red;");
        profile.setOnMouseClicked((e)->{
            System.out.println("enter profile");
            stage.setScene(new Scene(new ProfileHome(stage , TicTacToeClient.playerHandler.playerDetails)));
        });

        profile.setFitHeight(56.0);
        profile.setFitWidth(67.0);
        profile.setImage(new Image(getClass().getResource("Images/icons8-username-48.png").toExternalForm()));
       // profilrbtn.setGraphic(profile);

        text1.setFill(javafx.scene.paint.Color.valueOf("#00000080"));
        text1.setLayoutX(73.0);
        text1.setLayoutY(129.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("name");
        text1.setFont(new Font("Berlin Sans FB", 20.0));

        text2.setFill(javafx.scene.paint.Color.valueOf("#00000080"));
        text2.setLayoutX(292.0);
        text2.setLayoutY(130.0);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("score");
        text2.setFont(new Font("Berlin Sans FB", 20.0));

        text3.setFill(javafx.scene.paint.Color.valueOf("#00000080"));
        text3.setLayoutX(497.0);
        text3.setLayoutY(129.0);
        text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text3.setStrokeWidth(0.0);
        text3.setText("Invitation");
        text3.setFont(new Font("Berlin Sans FB", 20.0));

        vBox.setLayoutX(73.0);
        vBox.setLayoutY(150.0);
        vBox.setPrefHeight(300.0);
        vBox.setPrefWidth(141.0);

        vBox0.setLayoutX(292.0);
        vBox0.setLayoutY(150.0);
        vBox0.setPrefHeight(300.0);
        vBox0.setPrefWidth(141.0);

        vBox1.setLayoutX(490.0);
        vBox1.setLayoutY(150.0);
        vBox1.setPrefHeight(300.0);
        vBox1.setPrefWidth(141.0);

        logoutBut.setLayoutX(22.0);
        logoutBut.setLayoutY(26.0);
        logoutBut.setMnemonicParsing(false);
        logoutBut.setPrefHeight(26.0);
        logoutBut.setPrefWidth(80.0);
        logoutBut.setStyle("-fx-background-color: #F35162; -fx-border-radius: 15; -fx-background-radius: 15;");
        logoutBut.setText("Log Out");
        logoutBut.setTextFill(javafx.scene.paint.Color.WHITE);
        logoutBut.setFont(new Font("Berlin Sans FB", 14.0));
        
        anchorPane.getChildren().add(profile);
        anchorPane.getChildren().add(rectangle);
        anchorPane.getChildren().add(text);
        anchorPane.getChildren().add(text0);
        anchorPane.getChildren().add(text1);
        anchorPane.getChildren().add(text2);
        anchorPane.getChildren().add(btnBack);
        anchorPane.getChildren().add(text3);
        anchorPane.getChildren().add(vBox);
        anchorPane.getChildren().add(vBox0);
        anchorPane.getChildren().add(vBox1);
        //anchorPane.getChildren().add(logoutBut);

        vBox.getChildren().clear();
        vBox0.getChildren().clear();
        vBox1.getChildren().clear();
        for (int i = 0; i < players.size(); i++) {
            /*if(i==5)
             {
             rectangle.setHeight(rectangle.getHeight()+((6-i)*75));
             }*/

            Text text_name = new Text();
            text_name.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            text_name.setStrokeWidth(0.0);
            text_name.setText(players.get(i).getUserName());
            text_name.setFont(new Font("Berlin Sans FB", 16.0));

            Text text_score = new Text();
            text_score.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            text_score.setStrokeWidth(0.0);
            text_score.setText(players.get(i).getScore() + "");
            text_score.setFont(new Font("Berlin Sans FB", 16.0));

            Button invite = new Button();
            invite.setMnemonicParsing(false);
            invite.setPrefHeight(30.0);
            invite.setPrefWidth(98.0);
            invite.setStyle("-fx-background-color: green; -fx-border-radius: 15; -fx-background-radius: 15;");
            invite.setText("Invite");
            invite.setTextFill(javafx.scene.paint.Color.WHITE);
            invite.setFont(new Font("Berlin Sans FB", 16.0));
            buttons.add(invite);

            vBox.getChildren().addAll(text_name, new Text("\n \n"));
            vBox0.getChildren().addAll(text_score, new Text("\n \n"));
            vBox1.getChildren().addAll(invite, new Text("\n"));

            String userName = players.get(i).getUserName();
            invite.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    invite.setDisable(true);
                    ArrayList msg = new ArrayList();
                    msg.add(3);
                    msg.add(userName);
                    String jsonInvitationonRequest = gson.toJson(msg);
                    TicTacToeClient.playerHandler.sendRequest(jsonInvitationonRequest);
                    invite.setDisable(true);
                    showAlertWithTimeout(userName);
                    invite.setDisable(false);

                }
            });

        }

        logoutBut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(new Scene(new SignIn(stage)));
            }
        });

        profilrbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //stage.setScene(new Scene(new ProfileHome(stage)));
            }
        });
    }

    static public void listPlayers(ArrayList<PlayerDetails> player, String user) {

        players = player;
        vBox.getChildren().clear();
        vBox0.getChildren().clear();
        vBox1.getChildren().clear();
        for (int i = 0; i < players.size(); i++) {
            /*if(i==5)
             {
             rectangle.setHeight(rectangle.getHeight()+((6-i)*75));
             }*/

            if (players.get(i).equals(user)) {
                continue;
            }

            Text text_name = new Text();
            text_name.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            text_name.setStrokeWidth(0.0);
            text_name.setText(players.get(i).getUserName());
            text_name.setFont(new Font("Berlin Sans FB", 16.0));

            Text text_score = new Text();
            text_score.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            text_score.setStrokeWidth(0.0);
            text_score.setText(players.get(i).getScore() + "");
            text_score.setFont(new Font("Berlin Sans FB", 16.0));

            Button invite = new Button();
            invite.setMnemonicParsing(false);
            invite.setPrefHeight(30.0);
            invite.setPrefWidth(98.0);
            invite.setStyle("-fx-background-color: green; -fx-border-radius: 15; -fx-background-radius: 15;");
            invite.setText("Invite");
            invite.setTextFill(javafx.scene.paint.Color.WHITE);
            invite.setFont(new Font("Berlin Sans FB", 16.0));
            buttons.add(invite);

            vBox.getChildren().addAll(text_name, new Text("\n \n"));
            vBox0.getChildren().addAll(text_score, new Text("\n \n"));
            vBox1.getChildren().addAll(invite, new Text("\n"));

            String userName = players.get(i).getUserName();
            invite.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    invite.setDisable(true);
                    ArrayList msg = new ArrayList();
                    msg.add(3);
                    msg.add(userName);
                    String jsonInvitationonRequest = gson.toJson(msg);
                    TicTacToeClient.playerHandler.sendRequest(jsonInvitationonRequest);
                    invite.setDisable(true);
                    showAlertWithTimeout(userName);
                    invite.setDisable(false);

                }
            });

        }
    }

    private static void showAlertWithTimeout(String userName) {
        alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("send invitation");
        alert.setHeaderText("sending invite to " + userName);

        // Set up a timeline to close the alert after 3 seconds
        timeline = new Timeline(new KeyFrame(Duration.seconds(30), e -> alert.close()));
        timeline.setCycleCount(1); // Run once

        // Show the alert and start the timeline
        alert.show();
        timeline.play();
    }

    public static void closeAlert() {
        timeline.stop();
        alert.close();
    }
}
