package tictactoeclient;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import playerhelper.PlayerDetails;
import playerhelper.PlayerHandler;

public class ProfileHome extends Pane {
    
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final ImageView imageView2;
    protected final ImageView imageView3;
    protected final Text text;
    protected final Rectangle rectangle;
    protected final Label label;
    protected final ImageView imageView4;
    protected final Label nameField;
    protected final Label label0;
    protected final PasswordField passField;
    protected final Label label1;
    protected final Label scoreField;
    protected final Button exitbtn;
    protected final Button savebtn;
    protected final ImageView imageView5;
    protected final ImageView imageView6;
    protected final ImageView imageView7;
    protected final ImageView imageView8;
    protected final Button editbtn;
    protected final Label userNameField;
    protected final Button recbtn1;
    protected final Button playbtn;
    
    public ProfileHome(Stage stage, PlayerDetails playerDetails) {
        
        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        imageView2 = new ImageView();
        imageView3 = new ImageView();
        text = new Text();
        rectangle = new Rectangle();
        label = new Label();
        imageView4 = new ImageView();
        nameField = new Label();
        label0 = new Label();
        passField = new PasswordField();
        label1 = new Label();
        scoreField = new Label();
        exitbtn = new Button();
        savebtn = new Button();
        imageView5 = new ImageView();
        imageView6 = new ImageView();
        imageView7 = new ImageView();
        imageView8 = new ImageView();
        editbtn = new Button();
        userNameField = new Label();
        recbtn1 = new Button();
        playbtn = new Button();
        
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color: #42C4F7;");
        
        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        
        imageView0.setFitHeight(84.0);
        imageView0.setFitWidth(125.0);
        imageView0.setLayoutX(29.0);
        imageView0.setLayoutY(7.0);
        imageView0.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));
        
        imageView1.setFitHeight(67.0);
        imageView1.setFitWidth(73.0);
        imageView1.setLayoutX(613.0);
        imageView1.setLayoutY(98.0);
        imageView1.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));
        
        imageView2.setFitHeight(84.0);
        imageView2.setFitWidth(106.0);
        imageView2.setLayoutX(-41.0);
        imageView2.setLayoutY(175.0);
        imageView2.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));
        
        imageView3.setFitHeight(67.0);
        imageView3.setFitWidth(125.0);
        imageView3.setLayoutX(564.0);
        imageView3.setLayoutY(16.0);
        imageView3.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));
        
        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(288.0);
        text.setLayoutY(61.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Profile");
        text.setFont(new Font("Berlin Sans FB", 36.0));
        
        rectangle.setArcWidth(55.0);
        rectangle.setFill(javafx.scene.paint.Color.WHITE);
        rectangle.setHeight(342.0);
        rectangle.setLayoutX(74.0);
        rectangle.setLayoutY(95.0);
        rectangle.setStroke(javafx.scene.paint.Color.WHITE);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setStyle("-fx-arc-height: 55;");
        rectangle.setWidth(524.0);
        
        label.setLayoutX(91.0);
        label.setLayoutY(223.0);
        label.setText("User Name :");
        label.setFont(new Font("Berlin Sans FB", 18.0));
        
        imageView4.setFitHeight(67.0);
        imageView4.setFitWidth(73.0);
        imageView4.setLayoutX(101.0);
        imageView4.setLayoutY(117.0);
        imageView4.setImage(new Image(getClass().getResource("Images/man2.png").toExternalForm()));
        
        nameField.setLayoutX(229.0);
        nameField.setLayoutY(140.0);
        nameField.setText(playerDetails.getName());
        nameField.setTextFill(javafx.scene.paint.Color.valueOf("#000000ba"));
        nameField.setFont(new Font("Berlin Sans FB", 18.0));
        
        label0.setLayoutX(91.0);
        label0.setLayoutY(266.0);
        label0.setText("Password : ");
        label0.setFont(new Font("Berlin Sans FB", 18.0));
        
        passField.setLayoutX(198.0);
        passField.setLayoutY(263.0);
        passField.setPrefHeight(27.0);
        passField.setPrefWidth(162.0);
        passField.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-border-radius: 15px; -fx-background-radius: 15px;");
        
        label1.setLayoutX(92.0);
        label1.setLayoutY(315.0);
        label1.setText("Score :");
        label1.setFont(new Font("Berlin Sans FB", 18.0));
        
        scoreField.setLayoutX(200.0);
        scoreField.setLayoutY(315.0);
        scoreField.setPrefHeight(17.0);
        scoreField.setPrefWidth(97.0);
        scoreField.setText(Integer.toString(playerDetails.getScore()));
        scoreField.setTextFill(javafx.scene.paint.Color.valueOf("#2e9a00"));
        scoreField.setFont(new Font("Berlin Sans FB", 18.0));
        
        exitbtn.setLayoutX(257.0);
        exitbtn.setLayoutY(387.0);
        exitbtn.setMnemonicParsing(false);
        exitbtn.setPrefHeight(33.0);
        exitbtn.setPrefWidth(117.0);
        exitbtn.setStyle("-fx-background-radius: 30px; -fx-background-color: #CE091E;");
        exitbtn.setText("Exit");
        exitbtn.setTextFill(javafx.scene.paint.Color.WHITE);
        exitbtn.setFont(new Font("Berlin Sans FB", 18.0));
        
        savebtn.setLayoutX(101.0);
        savebtn.setLayoutY(387.0);
        savebtn.setMnemonicParsing(false);
        savebtn.setPrefHeight(33.0);
        savebtn.setPrefWidth(117.0);
        savebtn.setStyle("-fx-background-radius: 30px; -fx-background-color: #2F43FB;");
        savebtn.setText("Save");
        savebtn.setTextFill(javafx.scene.paint.Color.WHITE);
        savebtn.setFont(new Font("Berlin Sans FB", 18.0));
        savebtn.setDisable(true);
        savebtn.setOpacity(0.0);
        savebtn.setOnAction((e) -> {
            playbtn.setDisable(false);
            playbtn.setOpacity(100.0);
        });
        
        imageView5.setFitHeight(67.0);
        imageView5.setFitWidth(125.0);
        imageView5.setLayoutX(613.0);
        imageView5.setLayoutY(302.0);
        imageView5.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));
        
        imageView6.setFitHeight(67.0);
        imageView6.setFitWidth(125.0);
        imageView6.setLayoutX(392.0);
        imageView6.setLayoutY(446.0);
        imageView6.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));
        
        imageView7.setFitHeight(67.0);
        imageView7.setFitWidth(125.0);
        imageView7.setLayoutX(12.0);
        imageView7.setLayoutY(446.0);
        imageView7.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));
        
        imageView8.setFitHeight(67.0);
        imageView8.setFitWidth(125.0);
        imageView8.setLayoutX(613.0);
        imageView8.setLayoutY(446.0);
        imageView8.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));
        
        editbtn.setLayoutX(399.0);
        editbtn.setLayoutY(260.0);
        editbtn.setMnemonicParsing(false);
        editbtn.setPrefHeight(33.0);
        editbtn.setPrefWidth(83.0);
        editbtn.setStyle("-fx-background-color: #2F43FB; -fx-background-radius: 30; -fx-border-radius: 30;");
        editbtn.setText("Edit");
        editbtn.setTextFill(javafx.scene.paint.Color.WHITE);
        editbtn.setFont(new Font("Berlin Sans FB", 18.0));
        editbtn.setOnAction((e) -> {
            savebtn.setOpacity(100.0);
            savebtn.setDisable(false);
            playbtn.setOpacity(0.0);
            playbtn.setDisable(true);
        });
        
        userNameField.setLayoutX(203.0);
        userNameField.setLayoutY(223.0);
        userNameField.setPrefHeight(21.0);
        userNameField.setPrefWidth(162.0);
        userNameField.setText(playerDetails.getUserName());
        userNameField.setTextFill(javafx.scene.paint.Color.valueOf("#000000ba"));
        userNameField.setFont(new Font("Berlin Sans FB", 18.0));
        
        recbtn1.setLayoutX(399.0);
        recbtn1.setLayoutY(309.0);
        recbtn1.setMnemonicParsing(false);
        recbtn1.setPrefHeight(33.0);
        recbtn1.setPrefWidth(83.0);
        recbtn1.setStyle("-fx-background-color: #2F43FB; -fx-background-radius: 30; -fx-border-radius: 30;");
        recbtn1.setText("Records");
        recbtn1.setTextFill(javafx.scene.paint.Color.WHITE);
        recbtn1.setFont(new Font("Berlin Sans FB", 18.0));
        
        playbtn.setLayoutX(101.0);
        playbtn.setLayoutY(387.0);
        playbtn.setMnemonicParsing(false);
        playbtn.setPrefHeight(33.0);
        playbtn.setPrefWidth(117.0);
        playbtn.setStyle("-fx-background-color: #2e9a00; -fx-background-radius: 30; -fx-border-radius: 30;");
        playbtn.setText("Play Game");
        playbtn.setTextFill(javafx.scene.paint.Color.WHITE);
        playbtn.setFont(new Font("Berlin Sans FB", 18.0));
        
        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        getChildren().add(imageView2);
        getChildren().add(imageView3);
        getChildren().add(text);
        getChildren().add(rectangle);
        getChildren().add(label);
        getChildren().add(imageView4);
        getChildren().add(nameField);
        getChildren().add(label0);
        getChildren().add(passField);
        getChildren().add(label1);
        getChildren().add(scoreField);
        getChildren().add(exitbtn);
        getChildren().add(savebtn);
        getChildren().add(imageView5);
        getChildren().add(imageView6);
        getChildren().add(imageView7);
        getChildren().add(imageView8);
        getChildren().add(editbtn);
        getChildren().add(userNameField);
        getChildren().add(recbtn1);
        getChildren().add(playbtn);
        
    }
}
