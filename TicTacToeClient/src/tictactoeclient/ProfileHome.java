package tic_tac_toe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

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
    protected final Label label0;
    protected final TextField textField;
    protected final Label label1;
    protected final PasswordField passwordField;
    protected final Label label2;
    protected final Label label3;
    protected final Button Exitbtn1;
    protected final Button findbtn1;

    public ProfileHome() {

        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        imageView2 = new ImageView();
        imageView3 = new ImageView();
        text = new Text();
        rectangle = new Rectangle();
        label = new Label();
        imageView4 = new ImageView();
        label0 = new Label();
        textField = new TextField();
        label1 = new Label();
        passwordField = new PasswordField();
        label2 = new Label();
        label3 = new Label();
        Exitbtn1 = new Button();
        findbtn1 = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
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
        imageView1.setLayoutX(564.0);
        imageView1.setLayoutY(95.0);
        imageView1.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        imageView2.setFitHeight(84.0);
        imageView2.setFitWidth(106.0);
        imageView2.setLayoutX(-41.0);
        imageView2.setLayoutY(175.0);
        imageView2.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        imageView3.setFitHeight(67.0);
        imageView3.setFitWidth(125.0);
        imageView3.setLayoutX(455.0);
        imageView3.setLayoutY(13.0);
        imageView3.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        text.setFill(javafx.scene.paint.Color.WHITE);
        text.setLayoutX(252.0);
        text.setLayoutY(59.0);
        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Profile");
        text.setFont(new Font("Berlin Sans FB", 36.0));

        rectangle.setArcWidth(55.0);
        rectangle.setFill(javafx.scene.paint.Color.WHITE);
        rectangle.setHeight(286.0);
        rectangle.setLayoutX(62.0);
        rectangle.setLayoutY(99.0);
        rectangle.setStroke(javafx.scene.paint.Color.WHITE);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setStyle("-fx-arc-height: 55;");
        rectangle.setWidth(492.0);

        label.setLayoutX(96.0);
        label.setLayoutY(200.0);
        label.setText("User Name :");
        label.setFont(new Font("Berlin Sans FB", 18.0));

        imageView4.setFitHeight(67.0);
        imageView4.setFitWidth(73.0);
        imageView4.setLayoutX(74.0);
        imageView4.setLayoutY(108.0);
        imageView4.setImage(new Image(getClass().getResource("images/man2.png").toExternalForm()));

        label0.setLayoutX(172.0);
        label0.setLayoutY(131.0);
        label0.setText("Ahmed");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#000000ba"));
        label0.setFont(new Font("Berlin Sans FB", 18.0));

        textField.setLayoutX(200.0);
        textField.setLayoutY(198.0);
        textField.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-background-radius: 15px; -fx-border-radius: 15px;");

        label1.setLayoutX(96.0);
        label1.setLayoutY(242.0);
        label1.setText("Password : ");
        label1.setFont(new Font("Berlin Sans FB", 18.0));

        passwordField.setLayoutX(200.0);
        passwordField.setLayoutY(239.0);
        passwordField.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-border-radius: 15px; -fx-background-radius: 15px;");

        label2.setLayoutX(96.0);
        label2.setLayoutY(281.0);
        label2.setText("Score :");
        label2.setFont(new Font("Berlin Sans FB", 18.0));

        label3.setLayoutX(166.0);
        label3.setLayoutY(281.0);
        label3.setPrefHeight(17.0);
        label3.setPrefWidth(97.0);
        label3.setText("500");
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#2e9a00"));
        label3.setFont(new Font("Berlin Sans FB", 18.0));

        Exitbtn1.setLayoutX(187.0);
        Exitbtn1.setLayoutY(344.0);
        Exitbtn1.setMnemonicParsing(false);
        Exitbtn1.setPrefHeight(33.0);
        Exitbtn1.setPrefWidth(83.0);
        Exitbtn1.setStyle("-fx-background-radius: 30px; -fx-background-color: #CE091E;");
        Exitbtn1.setText("Exit");
        Exitbtn1.setTextFill(javafx.scene.paint.Color.WHITE);
        Exitbtn1.setFont(new Font("Berlin Sans FB", 18.0));

        findbtn1.setLayoutX(91.0);
        findbtn1.setLayoutY(344.0);
        findbtn1.setMnemonicParsing(false);
        findbtn1.setPrefHeight(33.0);
        findbtn1.setPrefWidth(73.0);
        findbtn1.setStyle("-fx-background-radius: 30px; -fx-background-color: #2F43FB;");
        findbtn1.setText("Save");
        findbtn1.setTextFill(javafx.scene.paint.Color.WHITE);
        findbtn1.setFont(new Font("Berlin Sans FB", 18.0));

        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        getChildren().add(imageView2);
        getChildren().add(imageView3);
        getChildren().add(text);
        getChildren().add(rectangle);
        getChildren().add(label);
        getChildren().add(imageView4);
        getChildren().add(label0);
        getChildren().add(textField);
        getChildren().add(label1);
        getChildren().add(passwordField);
        getChildren().add(label2);
        getChildren().add(label3);
        getChildren().add(Exitbtn1);
        getChildren().add(findbtn1);

    }
}
