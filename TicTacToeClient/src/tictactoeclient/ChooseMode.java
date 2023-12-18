package tictactoeclient;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ChooseMode extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final Pane pane;
    protected final Button SingleModeBtn;
    protected final Button DualModeBtn;
    protected final ImageView imageView2;
    protected final ImageView imageView3;
    protected final Button BackBtn;
    protected final ImageView imageView4;
    protected final ImageView imageView5;

    public ChooseMode(Stage stage) {

        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        pane = new Pane();
        SingleModeBtn = new Button();
        DualModeBtn = new Button();
        imageView2 = new ImageView();
        imageView3 = new ImageView();
        BackBtn = new Button();
        imageView4 = new ImageView();
        imageView5 = new ImageView();

        setId("AnchorPane");
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color: #42C4F7;");

        imageView.setFitHeight(61.0);
        imageView.setFitWidth(118.0);
        imageView.setLayoutX(582.0);
        imageView.setLayoutY(16.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        imageView0.setFitHeight(80.0);
        imageView0.setFitWidth(122.0);
        imageView0.setLayoutX(24.0);
        imageView0.setLayoutY(388.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        imageView1.setFitHeight(150.0);
        imageView1.setFitWidth(200.0);
        imageView1.setLayoutX(509.0);
        imageView1.setLayoutY(400.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        pane.setLayoutX(172.0);
        pane.setLayoutY(141.0);
        pane.setPrefHeight(246.0);
        pane.setPrefWidth(391.0);
        pane.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 20;");

        SingleModeBtn.setLayoutX(49.0);
        SingleModeBtn.setLayoutY(42.0);
        SingleModeBtn.setMnemonicParsing(false);
        SingleModeBtn.setPrefHeight(46.0);
        SingleModeBtn.setPrefWidth(279.0);
        SingleModeBtn.setStyle("-fx-background-color: #F35162; -fx-background-radius: 40;");
        SingleModeBtn.setText("Single Mode");
        SingleModeBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        SingleModeBtn.setFont(new Font("Berlin Sans FB Bold", 30.0));

        DualModeBtn.setLayoutX(49.0);
        DualModeBtn.setLayoutY(159.0);
        DualModeBtn.setMnemonicParsing(false);
        DualModeBtn.setPrefHeight(61.0);
        DualModeBtn.setPrefWidth(279.0);
        DualModeBtn.setStyle("-fx-background-color: #2F43FB; -fx-background-radius: 40;");
        DualModeBtn.setText("Dual Mode");
        DualModeBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        DualModeBtn.setFont(new Font("Berlin Sans FB Bold", 30.0));

        imageView2.setFitHeight(95.0);
        imageView2.setFitWidth(142.0);
        imageView2.setLayoutX(392.0);
        imageView2.setLayoutY(26.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        imageView3.setFitHeight(61.0);
        imageView3.setFitWidth(99.0);
        imageView3.setLayoutX(38.0);
        imageView3.setLayoutY(177.0);
        imageView3.setPickOnBounds(true);
        imageView3.setPreserveRatio(true);
        imageView3.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        BackBtn.setLayoutX(16.0);
        BackBtn.setLayoutY(16.0);
        BackBtn.setMnemonicParsing(false);
        BackBtn.setPrefHeight(60.0);
        BackBtn.setPrefWidth(76.0);
        BackBtn.setStyle("-fx-background-color: #42C4F7;");

        imageView4.setFitHeight(40.0);
        imageView4.setFitWidth(38.0);
        imageView4.setPickOnBounds(true);
        imageView4.setPreserveRatio(true);
        imageView4.setImage(new Image(getClass().getResource("Images/backBtn.png").toExternalForm()));
        BackBtn.setGraphic(imageView4);

        imageView5.setFitHeight(61.0);
        imageView5.setFitWidth(99.0);
        imageView5.setLayoutX(142.0);
        imageView5.setLayoutY(43.0);
        imageView5.setPickOnBounds(true);
        imageView5.setPreserveRatio(true);
        imageView5.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        pane.getChildren().add(SingleModeBtn);
        pane.getChildren().add(DualModeBtn);
        getChildren().add(pane);
        getChildren().add(imageView2);
        getChildren().add(imageView3);
        getChildren().add(BackBtn);
        getChildren().add(imageView5);

        BackBtn.setOnAction(e -> {
            stage.setScene(new Scene(new SignIn(stage)));
        });
        SingleModeBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(new Scene(new ComputerMode(stage)));
            }
        });
        DualModeBtn.setOnAction(e -> {
            stage.setScene(new Scene(new LocalMode(stage)));
        });

    }
}
