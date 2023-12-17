package tictactoeclient;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public  class StartScreen extends AnchorPane {

    protected final Pane pane;
    protected final Button startBtn;
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final ImageView imageView2;
    protected final ImageView imageView3;

    public StartScreen() {

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
        setPrefHeight(648.0);
        setPrefWidth(870.0);

        pane.setLayoutY(-6.0);
        pane.setPrefHeight(656.0);
        pane.setPrefWidth(870.0);
        pane.setStyle("-fx-background-color: #42C4F7;");

        startBtn.setLayoutX(290.0);
        startBtn.setLayoutY(495.0);
        startBtn.setMnemonicParsing(false);
        startBtn.setPrefHeight(72.0);
        startBtn.setPrefWidth(261.0);
        startBtn.setStyle("-fx-background-radius: 35; -fx-background-color: #6A629E;");
        startBtn.setText("Start");
        startBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        startBtn.setFont(new Font("Berlin Sans FB Bold", 35.0));

        imageView.setFitHeight(161.0);
        imageView.setFitWidth(243.0);
        imageView.setLayoutX(539.0);
        imageView.setLayoutY(69.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        imageView0.setFitHeight(161.0);
        imageView0.setFitWidth(213.0);
        imageView0.setLayoutX(72.0);
        imageView0.setLayoutY(79.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        imageView1.setFitHeight(144.0);
        imageView1.setFitWidth(238.0);
        imageView1.setLayoutX(64.0);
        imageView1.setLayoutY(351.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        imageView2.setFitHeight(161.0);
        imageView2.setFitWidth(238.0);
        imageView2.setLayoutX(599.0);
        imageView2.setLayoutY(343.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        imageView3.setFitHeight(480.0);
        imageView3.setFitWidth(238.0);
        imageView3.setLayoutX(301.0);
        imageView3.setLayoutY(136.0);
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
