package tictactoeclient;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

public class Invitation extends Pane {

    protected final Label playername;
    protected final Label label;
    protected final Button acceptbtn;
    protected final Button rejectbtn;
    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final ImageView imageView1;
    protected final ImageView imageView2;

    public Invitation() {

        playername = new Label();
        label = new Label();
        acceptbtn = new Button();
        rejectbtn = new Button();
        imageView = new ImageView();
        imageView0 = new ImageView();
        imageView1 = new ImageView();
        imageView2 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(200.0);
        setPrefWidth(400.0);
        setStyle("-fx-background-color: #42C4F7;");

        playername.setLayoutX(28.0);
        playername.setLayoutY(83.0);
        playername.setPrefHeight(21.0);
        playername.setPrefWidth(93.0);
        playername.setText("  naden");
        playername.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        playername.setTextFill(javafx.scene.paint.Color.RED);
        playername.setFont(new Font("Berlin Sans FB Demi Bold", 24.0));

        label.setLayoutX(121.0);
        label.setLayoutY(83.0);
        label.setText("inviting you to play....");
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Berlin Sans FB", 24.0));

        acceptbtn.setLayoutX(85.0);
        acceptbtn.setLayoutY(138.0);
        acceptbtn.setMnemonicParsing(false);
        acceptbtn.setPrefHeight(27.0);
        acceptbtn.setPrefWidth(87.0);
        acceptbtn.setStyle("-fx-background-radius: 30px; -fx-background-color: #00886D;");
        acceptbtn.setText("Accept");
        acceptbtn.setTextFill(javafx.scene.paint.Color.WHITE);
        acceptbtn.setFont(new Font("Berlin Sans FB", 18.0));

        rejectbtn.setLayoutX(241.0);
        rejectbtn.setLayoutY(138.0);
        rejectbtn.setMnemonicParsing(false);
        rejectbtn.setPrefHeight(33.0);
        rejectbtn.setPrefWidth(93.0);
        rejectbtn.setStyle("-fx-background-radius: 30px; -fx-background-color: #CE091E;");
        rejectbtn.setText("Reject");
        rejectbtn.setTextFill(javafx.scene.paint.Color.WHITE);
        rejectbtn.setFont(new Font("Berlin Sans FB", 18.0));

        imageView.setFitHeight(58.0);
        imageView.setFitWidth(76.0);
        imageView.setLayoutX(289.0);
        imageView.setLayoutY(10.0);
        imageView.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        imageView0.setFitHeight(47.0);
        imageView0.setFitWidth(76.0);
        imageView0.setLayoutX(-24.0);
        imageView0.setLayoutY(115.0);
        imageView0.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        imageView1.setFitHeight(58.0);
        imageView1.setFitWidth(76.0);
        imageView1.setLayoutX(348.0);
        imageView1.setLayoutY(115.0);
        imageView1.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        imageView2.setFitHeight(82.0);
        imageView2.setFitWidth(133.0);
        imageView2.setLayoutX(7.0);
        imageView2.setLayoutY(8.0);
        imageView2.setPickOnBounds(true);
        imageView2.setPreserveRatio(true);
        imageView2.setImage(new Image(getClass().getResource("Images/cloud.png").toExternalForm()));

        getChildren().add(playername);
        getChildren().add(label);
        getChildren().add(acceptbtn);
        getChildren().add(rejectbtn);
        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(imageView1);
        getChildren().add(imageView2);

    }
}
