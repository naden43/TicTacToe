package tictactoeclient;

import com.google.gson.Gson;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import playerhelper.PlayerDetails;

public class SignIn extends AnchorPane {

    protected final AnchorPane anchorPane;
    public static final Button btnSignIn;
    protected final Button btnPlayOffline;
    public static final Button btnRegister;
    protected final TextField txtFieldUserName;
    protected final ImageView imgUserName;
    protected final ImageView imgPassward;
    protected final PasswordField passFieldPassward;
    protected final Text textUserOrPassWrong;
    protected final ImageView imgHeader;
    protected final Button btnBack;
    Gson gson;
    Thread th;
    static Stage stage;

    static {
        btnSignIn = new Button();
        btnRegister = new Button();
    }

    public SignIn(Stage stage) {
        this.stage = stage;
        anchorPane = new AnchorPane();
        btnPlayOffline = new Button();

        txtFieldUserName = new TextField();
        imgUserName = new ImageView();
        imgPassward = new ImageView();
        passFieldPassward = new PasswordField();
        textUserOrPassWrong = new Text();
        imgHeader = new ImageView();
        btnBack = new Button();
        gson = new Gson();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color: #42c4f7;");

        anchorPane.setLayoutX(138.0);
        anchorPane.setLayoutY(128.0);
        anchorPane.setPrefHeight(335.0);
        anchorPane.setPrefWidth(420.0);
        anchorPane.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 10px;");

        btnSignIn.setLayoutX(123.0);
        btnSignIn.setLayoutY(168.0);
        btnSignIn.setMnemonicParsing(false);
        btnSignIn.setPrefHeight(31.0);
        btnSignIn.setPrefWidth(175.0);
        btnSignIn.setStyle("-fx-background-color: #a89aff; -fx-background-radius: 30px;");
        btnSignIn.setText("Sign in");
        btnSignIn.setTextFill(javafx.scene.paint.Color.WHITE);
        btnSignIn.setFont(new Font("Berlin Sans FB Bold", 15.0));

        btnPlayOffline.setLayoutX(123.0);
        btnPlayOffline.setLayoutY(244.0);
        btnPlayOffline.setMnemonicParsing(false);
        btnPlayOffline.setPrefHeight(31.0);
        btnPlayOffline.setPrefWidth(175.0);
        btnPlayOffline.setStyle("-fx-background-color: #a89aff; -fx-background-radius: 30px;");
        btnPlayOffline.setText("Play Offline");
        btnPlayOffline.setTextFill(javafx.scene.paint.Color.WHITE);
        btnPlayOffline.setFont(new Font("Berlin Sans FB Bold", 15.0));

        btnRegister.setLayoutX(123.0);
        btnRegister.setLayoutY(206.0);
        btnRegister.setMnemonicParsing(false);
        btnRegister.setPrefHeight(31.0);
        btnRegister.setPrefWidth(175.0);
        btnRegister.setStyle("-fx-background-color: #a89aff; -fx-background-radius: 30px;");
        btnRegister.setText("Register");
        btnRegister.setTextFill(javafx.scene.paint.Color.WHITE);
        btnRegister.setFont(new Font("Berlin Sans FB Bold", 15.0));

        txtFieldUserName.setLayoutX(95.0);
        txtFieldUserName.setLayoutY(60.0);
        txtFieldUserName.setPrefHeight(31.0);
        txtFieldUserName.setPrefWidth(222.0);
        txtFieldUserName.setPromptText("Enter Username");
        txtFieldUserName.setStyle("-fx-border-radius: 50px; -fx-background-radius: 50px;");

        imgUserName.setFitHeight(38.0);
        imgUserName.setFitWidth(24.0);
        imgUserName.setLayoutX(59.0);
        imgUserName.setLayoutY(64.0);
        imgUserName.setPickOnBounds(true);
        imgUserName.setPreserveRatio(true);
        imgUserName.setImage(new Image(getClass().getResource("Images/icons8-username-48.png").toExternalForm()));

        imgPassward.setFitHeight(48.0);
        imgPassward.setFitWidth(20.0);
        imgPassward.setLayoutX(61.0);
        imgPassward.setLayoutY(115.0);
        imgPassward.setPickOnBounds(true);
        imgPassward.setPreserveRatio(true);
        imgPassward.setImage(new Image(getClass().getResource("Images/icons8-password-48.png").toExternalForm()));

        passFieldPassward.setLayoutX(95.0);
        passFieldPassward.setLayoutY(110.0);
        passFieldPassward.setPrefHeight(31.0);
        passFieldPassward.setPrefWidth(222.0);
        passFieldPassward.setPromptText("Enter Passward");
        passFieldPassward.setStyle("-fx-background-radius: 50px; -fx-background-radius: 50px;");

        textUserOrPassWrong.setDisable(true);
        textUserOrPassWrong.setFill(javafx.scene.paint.Color.RED);
        textUserOrPassWrong.setLayoutX(140.0);
        textUserOrPassWrong.setLayoutY(157.0);
        textUserOrPassWrong.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textUserOrPassWrong.setStrokeWidth(0.0);
        textUserOrPassWrong.setStyle("-fx-font-size: 10;");
        textUserOrPassWrong.setText("wrong username or passward");
        textUserOrPassWrong.setVisible(false);
        textUserOrPassWrong.setWrappingWidth(134.99999718368053);

        imgHeader.setFitHeight(141.0);
        imgHeader.setFitWidth(700.0);
        imgHeader.setLayoutX(-2.0);
        imgHeader.setPickOnBounds(true);
        imgHeader.setPreserveRatio(true);
        imgHeader.setImage(new Image(getClass().getResource("Images/tic-tac-toe head.png").toExternalForm()));

        btnBack.setLayoutX(26.0);
        btnBack.setLayoutY(18.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(31.0);
        btnBack.setPrefWidth(39.0);
        btnBack.setStyle("-fx-background-color: #42c4f7;");

        anchorPane.getChildren().add(btnSignIn);
        anchorPane.getChildren().add(btnPlayOffline);
        anchorPane.getChildren().add(btnRegister);
        anchorPane.getChildren().add(txtFieldUserName);
        anchorPane.getChildren().add(imgUserName);
        anchorPane.getChildren().add(imgPassward);
        anchorPane.getChildren().add(passFieldPassward);
        anchorPane.getChildren().add(textUserOrPassWrong);
        getChildren().add(anchorPane);
        getChildren().add(imgHeader);
        getChildren().add(btnBack);

        btnPlayOffline.setOnAction(e -> {

            stage.setScene(new Scene(new ChooseMode(stage)));
        });

        btnRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(new Scene(new Register(stage)));
            }
        });
        
        btnSignIn.setOnAction(e -> {

            PlayerDetails playerDetails = new PlayerDetails();
            playerDetails.setUserName(txtFieldUserName.getText());
            playerDetails.setPassword(passFieldPassward.getText());

            // Convert PlayerDetails object to JSON
            ArrayList jsonArr = new ArrayList();
            jsonArr.add(2);
            jsonArr.add(gson.toJson(playerDetails));

            String jsonRegistrationRequest = gson.toJson(jsonArr);
            TicTacToeClient.playerHandler.sendRequest(jsonRegistrationRequest);
            
            //stage.setScene(new Scene (new ChoosePlayer(stage)));
        });
    }

    static public void trueLogin(ArrayList<PlayerDetails> players) {
        stage.setScene(new Scene(new ChoosePlayer(stage, players)));
    }
}
