package tictactoeclient;

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

public class Register extends AnchorPane {

    protected final AnchorPane anchorPane;
    protected final Button btnRegister;
    protected final TextField txtFieldUserName;
    protected final ImageView imgUserName;
    protected final ImageView imgPassward;
    protected final PasswordField passFieldPassward;
    protected final ImageView imageView;
    protected final TextField txtFieldName;
    protected final Text textUsernameTaken;
    protected final ImageView imgHeader;
    protected final Button btnBack;
    protected final ImageView imageView0;

    public Register(Stage stage) {

        anchorPane = new AnchorPane();
        btnRegister = new Button();
        txtFieldUserName = new TextField();
        imgUserName = new ImageView();
        imgPassward = new ImageView();
        passFieldPassward = new PasswordField();
        imageView = new ImageView();
        txtFieldName = new TextField();
        textUsernameTaken = new Text();
        imgHeader = new ImageView();
        btnBack = new Button();
        imageView0 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color: #42c4f7;");

        anchorPane.setLayoutX(140.0);
        anchorPane.setLayoutY(128.0);
        anchorPane.setPrefHeight(335.0);
        anchorPane.setPrefWidth(420.0);
        anchorPane.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 10px;");

        btnRegister.setLayoutX(162.0);
        btnRegister.setLayoutY(213.0);
        btnRegister.setMnemonicParsing(false);
        btnRegister.setPrefHeight(38.0);
        btnRegister.setPrefWidth(107.0);
        btnRegister.setStyle("-fx-background-radius: 10px; -fx-background-color: #a89aff;");
        btnRegister.setText("Register");
        btnRegister.setTextFill(javafx.scene.paint.Color.WHITE);
        btnRegister.setFont(new Font("Berlin Sans FB Bold", 18.0));

        txtFieldUserName.setLayoutX(150.0);
        txtFieldUserName.setLayoutY(60.0);
        txtFieldUserName.setPrefHeight(31.0);
        txtFieldUserName.setPrefWidth(135.0);
        txtFieldUserName.setPromptText("Enter Username");
        txtFieldUserName.setStyle("-fx-border-radius: 50px; -fx-background-radius: 50px;");

        imgUserName.setFitHeight(38.0);
        imgUserName.setFitWidth(24.0);
        imgUserName.setLayoutX(115.0);
        imgUserName.setLayoutY(62.0);
        imgUserName.setPickOnBounds(true);
        imgUserName.setPreserveRatio(true);
        imgUserName.setImage(new Image(getClass().getResource("Images/icons8-username-48.png").toExternalForm()));

        imgPassward.setFitHeight(48.0);
        imgPassward.setFitWidth(20.0);
        imgPassward.setLayoutX(117.0);
        imgPassward.setLayoutY(105.0);
        imgPassward.setPickOnBounds(true);
        imgPassward.setPreserveRatio(true);
        imgPassward.setImage(new Image(getClass().getResource("Images/icons8-password-48.png").toExternalForm()));

        passFieldPassward.setLayoutX(150.0);
        passFieldPassward.setLayoutY(100.0);
        passFieldPassward.setPrefHeight(31.0);
        passFieldPassward.setPrefWidth(135.0);
        passFieldPassward.setPromptText("Enter Passward");
        passFieldPassward.setStyle("-fx-background-radius: 50px; -fx-background-radius: 50px;");

        imageView.setFitHeight(31.0);
        imageView.setFitWidth(20.0);
        imageView.setLayoutX(117.0);
        imageView.setLayoutY(148.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Images/pen-64.png").toExternalForm()));

        txtFieldName.setLayoutX(150.0);
        txtFieldName.setLayoutY(142.0);
        txtFieldName.setPrefHeight(31.0);
        txtFieldName.setPrefWidth(135.0);
        txtFieldName.setPromptText("Enter Your Name");
        txtFieldName.setStyle("-fx-border-radius: 50px; -fx-background-radius: 50px;");

        textUsernameTaken.setFill(javafx.scene.paint.Color.RED);
        textUsernameTaken.setLayoutX(117.0);
        textUsernameTaken.setLayoutY(199.0);
        textUsernameTaken.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        textUsernameTaken.setStrokeWidth(0.0);
        textUsernameTaken.setStyle("-fx-font-size: 9;");
        textUsernameTaken.setText("user name is already taken, try another one");
        textUsernameTaken.setVisible(false);
        textUsernameTaken.setWrappingWidth(198.13677978515625);

        imgHeader.setFitHeight(141.0);
        imgHeader.setFitWidth(700.0);
        imgHeader.setLayoutX(-2.0);
        imgHeader.setPickOnBounds(true);
        imgHeader.setPreserveRatio(true);
        imgHeader.setImage(new Image(getClass().getResource("Images/tic-tac-toe head.png").toExternalForm()));

        btnBack.setLayoutX(30.0);
        btnBack.setLayoutY(30.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(20.0);
        btnBack.setPrefWidth(20.0);
        btnBack.setStyle("-fx-background-color: #42c4f7;");
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(new Scene(new SignIn(stage)));
            }
        });

        imageView0.setFitHeight(33.0);
        imageView0.setFitWidth(33.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("Images/back.png").toExternalForm()));
        btnBack.setGraphic(imageView0);

        anchorPane.getChildren().add(btnRegister);
        anchorPane.getChildren().add(txtFieldUserName);
        anchorPane.getChildren().add(imgUserName);
        anchorPane.getChildren().add(imgPassward);
        anchorPane.getChildren().add(passFieldPassward);
        anchorPane.getChildren().add(imageView);
        anchorPane.getChildren().add(txtFieldName);
        anchorPane.getChildren().add(textUsernameTaken);
        getChildren().add(anchorPane);
        getChildren().add(imgHeader);
        getChildren().add(btnBack);

    }
}
