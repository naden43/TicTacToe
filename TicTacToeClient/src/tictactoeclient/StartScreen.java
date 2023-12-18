package tictactoeclient;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public  class StartScreen extends AnchorPane {

    protected final Pane pane;
    protected final Button startBtn;
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final ImageView imageView2;
    protected final ImageView imageView3;

    public StartScreen(Stage stage) {

        pane = new Pane();
        startBtn = new Button();
        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        imageView2 = new ImageView();
        imageView3 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(700.0);

        pane.setPrefHeight(520.0);
        pane.setPrefWidth(720.0);
        pane.setStyle("-fx-background-color: #42C4F7;");

        startBtn.setLayoutX(237.0);
        startBtn.setLayoutY(384.0);
        startBtn.setMnemonicParsing(false);
        startBtn.setPrefHeight(55.0);
        startBtn.setPrefWidth(213.0);
        startBtn.setStyle("-fx-background-radius: 35; -fx-background-color: #6A629E;");
        startBtn.setText("Start");
        startBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        startBtn.setFont(new Font("Berlin Sans FB Bold", 30.0));

        startBtn.setOnAction(e -> {
            stage.setScene(new Scene(new SignIn(stage)));
        });
        imageView.setFitHeight(103.0);
        imageView.setFitWidth(157.0);
        imageView.setLayoutX(440.0);
        imageView.setLayoutY(47.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        imageView0.setFitHeight(108.0);
        imageView0.setFitWidth(152.0);
        imageView0.setLayoutX(36.0);
        imageView0.setLayoutY(47.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        imageView1.setFitHeight(119.0);
        imageView1.setFitWidth(187.0);
        imageView1.setLayoutX(43.0);
        imageView1.setLayoutY(274.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        imageView2.setFitHeight(144.0);
        imageView2.setFitWidth(198.0);
        imageView2.setLayoutX(488.0);
        imageView2.setLayoutY(250.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        imageView3.setFitHeight(211.0);
        imageView3.setFitWidth(176.0);
        imageView3.setLayoutX(258.0);
        imageView3.setLayoutY(123.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("Images/tic-tac-toe.png").toExternalForm()));

        pane.getChildren().add(startBtn);
        pane.getChildren().add(imageView);
        pane.getChildren().add(imageView0);
        pane.getChildren().add(imageView1);
        pane.getChildren().add(imageView2);
        pane.getChildren().add(imageView3);
        getChildren().add(pane);

    }
}
