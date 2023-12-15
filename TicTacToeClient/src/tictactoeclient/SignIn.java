package tic_tac_toe;

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

public class SignIn extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final Button btnSignIn;
    protected final Button btnPlayOffline;
    protected final Button btnRegister;
    protected final TextField txtFieldUserName;
    protected final ImageView imgUserName;
    protected final ImageView imgPassward;
    protected final PasswordField passFieldPassward;
    protected final Text textUserOrPassWrong;
    protected final ImageView imgHeader;
    protected final Button btnBack;
    protected final ImageView imageView;

    public SignIn(Stage stage) {

        anchorPane = new AnchorPane();
        btnSignIn = new Button();
        btnPlayOffline = new Button();
        btnRegister = new Button();
        txtFieldUserName = new TextField();
        imgUserName = new ImageView();
        imgPassward = new ImageView();
        passFieldPassward = new PasswordField();
        textUserOrPassWrong = new Text();
        imgHeader = new ImageView();
        btnBack = new Button();
        imageView = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #42c4f7;");

        anchorPane.setLayoutX(121.0);
        anchorPane.setLayoutY(110.0);
        anchorPane.setPrefHeight(245.0);
        anchorPane.setPrefWidth(350.0);
        anchorPane.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 10px;");

        btnSignIn.setLayoutX(136.0);
        btnSignIn.setLayoutY(125.0);
        btnSignIn.setMnemonicParsing(false);
        btnSignIn.setPrefHeight(25.0);
        btnSignIn.setPrefWidth(93.0);
        btnSignIn.setStyle("-fx-background-color: #a89aff; -fx-background-radius: 10px;");
        btnSignIn.setText("Sign in");
        btnSignIn.setTextFill(javafx.scene.paint.Color.WHITE);
        btnSignIn.setFont(new Font("Berlin Sans FB Bold", 12.0));

        btnPlayOffline.setLayoutX(136.0);
        btnPlayOffline.setLayoutY(199.0);
        btnPlayOffline.setMnemonicParsing(false);
        btnPlayOffline.setPrefHeight(25.0);
        btnPlayOffline.setPrefWidth(93.0);
        btnPlayOffline.setStyle("-fx-background-color: #a89aff; -fx-background-radius: 10px;");
        btnPlayOffline.setText("Play Offline");
        btnPlayOffline.setTextFill(javafx.scene.paint.Color.WHITE);
        btnPlayOffline.setFont(new Font("Berlin Sans FB Bold", 12.0));

        btnRegister.setLayoutX(136.0);
        btnRegister.setLayoutY(163.0);
        btnRegister.setMnemonicParsing(false);
        btnRegister.setPrefHeight(25.0);
        btnRegister.setPrefWidth(93.0);
        btnRegister.setStyle("-fx-background-color: #a89aff; -fx-background-radius: 10px;");
        btnRegister.setText("Register");
        btnRegister.setTextFill(javafx.scene.paint.Color.WHITE);
        btnRegister.setFont(new Font("Berlin Sans FB Bold", 12.0));
        btnRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Scene scene = new Scene(new Register(stage));
                stage.setScene(scene);
                
            }
        });
        

        txtFieldUserName.setLayoutX(116.0);
        txtFieldUserName.setLayoutY(35.0);
        txtFieldUserName.setPrefHeight(31.0);
        txtFieldUserName.setPrefWidth(135.0);
        txtFieldUserName.setPromptText("Enter Username");
        txtFieldUserName.setStyle("-fx-border-radius: 50px; -fx-background-radius: 50px;");

        imgUserName.setFitHeight(38.0);
        imgUserName.setFitWidth(24.0);
        imgUserName.setLayoutX(81.0);
        imgUserName.setLayoutY(37.0);
        imgUserName.setPickOnBounds(true);
        imgUserName.setPreserveRatio(true);
        imgUserName.setImage(new Image(getClass().getResource("Images/icons8-username-48.png").toExternalForm()));

        imgPassward.setFitHeight(48.0);
        imgPassward.setFitWidth(20.0);
        imgPassward.setLayoutX(83.0);
        imgPassward.setLayoutY(80.0);
        imgPassward.setPickOnBounds(true);
        imgPassward.setPreserveRatio(true);
        imgPassward.setImage(new Image(getClass().getResource("Images/icons8-password-48.png").toExternalForm()));

        passFieldPassward.setLayoutX(116.0);
        passFieldPassward.setLayoutY(73.0);
        passFieldPassward.setPrefHeight(31.0);
        passFieldPassward.setPrefWidth(135.0);
        passFieldPassward.setPromptText("Enter Passward");
        passFieldPassward.setStyle("-fx-background-radius: 50px; -fx-background-radius: 50px;");

        textUserOrPassWrong.setDisable(true);
        textUserOrPassWrong.setFill(javafx.scene.paint.Color.RED);
        textUserOrPassWrong.setLayoutX(119.0);
        textUserOrPassWrong.setLayoutY(118.0);
        textUserOrPassWrong.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textUserOrPassWrong.setStrokeWidth(0.0);
        textUserOrPassWrong.setStyle("-fx-font-size: 9;");
        textUserOrPassWrong.setText("wrong username or passward");
        textUserOrPassWrong.setVisible(false);
        textUserOrPassWrong.setWrappingWidth(135.00000029802322);

        imgHeader.setFitHeight(111.0);
        imgHeader.setFitWidth(602.0);
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

        imageView.setFitHeight(28.0);
        imageView.setFitWidth(27.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Images/back.png").toExternalForm()));
        btnBack.setGraphic(imageView);

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

    }
}
