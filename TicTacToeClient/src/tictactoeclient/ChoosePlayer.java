package tic_tac_toe;

import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ChoosePlayer extends Pane {

    protected final Text text;
    protected final Text text0;
    protected final Rectangle rectangle;
    protected final Text text1;
    protected final Text text2;
    protected final ListView nameList;
    protected final ListView scoreList;
    protected final ListView btnList;
    protected final Button btnBack;
    protected final ImageView imageView;
    protected final Button profilrbtn;
    protected final ImageView imageView0;
    protected final Text text3;

    public ChoosePlayer() {

        text = new Text();
        text0 = new Text();
        rectangle = new Rectangle();
        text1 = new Text();
        text2 = new Text();
        nameList = new ListView();
        scoreList = new ListView();
        btnList = new ListView();
        btnBack = new Button();
        imageView = new ImageView();
        profilrbtn = new Button();
        imageView0 = new ImageView();
        text3 = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        setStyle("-fx-background-color: #42C4F7;");

        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Text");

        text0.setFill(javafx.scene.paint.Color.WHITE);
        text0.setLayoutX(209.0);
        text0.setLayoutY(57.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Avaliable Players");
        text0.setWrappingWidth(182.11328125);
        text0.setFont(new Font("Berlin Sans FB", 24.0));

        rectangle.setArcHeight(55.0);
        rectangle.setArcWidth(55.0);
        rectangle.setFill(javafx.scene.paint.Color.WHITE);
        rectangle.setHeight(302.0);
        rectangle.setLayoutX(32.0);
        rectangle.setLayoutY(64.0);
        rectangle.setStroke(javafx.scene.paint.Color.WHITE);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(547.0);

        text1.setFill(javafx.scene.paint.Color.valueOf("#00000080"));
        text1.setLayoutX(84.0);
        text1.setLayoutY(97.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("name");
        text1.setFont(new Font("Berlin Sans FB", 18.0));

        text2.setFill(javafx.scene.paint.Color.valueOf("#00000080"));
        text2.setLayoutX(278.0);
        text2.setLayoutY(95.0);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("score");
        text2.setFont(new Font("Berlin Sans FB", 18.0));

        nameList.setLayoutX(84.0);
        nameList.setLayoutY(115.0);
        nameList.setPrefHeight(200.0);
        nameList.setPrefWidth(150.0);
        nameList.setStyle("-fx-border-color: white;");
        nameList.setVisible(false);

        scoreList.setLayoutX(278.0);
        scoreList.setLayoutY(115.0);
        scoreList.setPrefHeight(200.0);
        scoreList.setPrefWidth(120.0);
        scoreList.setStyle("-fx-border-color: white;");

        btnList.setLayoutX(426.0);
        btnList.setLayoutY(115.0);
        btnList.setPrefHeight(200.0);
        btnList.setPrefWidth(141.0);
        btnList.setStyle("-fx-border-color: white;");

        btnBack.setLayoutX(7.0);
        btnBack.setLayoutY(4.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(25.0);
        btnBack.setPrefWidth(22.0);
        btnBack.setStyle("-fx-background-color: #42C4F7;");

        imageView.setFitHeight(29.0);
        imageView.setFitWidth(25.0);
        imageView.setImage(new Image(getClass().getResource("Images/back.png").toExternalForm()));
        btnBack.setGraphic(imageView);

        profilrbtn.setLayoutX(518.0);
        profilrbtn.setLayoutY(-7.0);
        profilrbtn.setMnemonicParsing(false);
        profilrbtn.setPrefHeight(49.0);
        profilrbtn.setPrefWidth(59.0);
        profilrbtn.setStyle("-fx-background-color: #42C4F7;");
        profilrbtn.setFont(new Font("Berlin Sans FB", 18.0));

        imageView0.setFitHeight(47.0);
        imageView0.setFitWidth(44.0);
        imageView0.setImage(new Image(getClass().getResource("Images/icons8-username-48.png").toExternalForm()));
        profilrbtn.setGraphic(imageView0);

        text3.setFill(javafx.scene.paint.Color.valueOf("#00000080"));
        text3.setLayoutX(470.0);
        text3.setLayoutY(97.0);
        text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text3.setStrokeWidth(0.0);
        text3.setText("Invitation");
        text3.setFont(new Font("Berlin Sans FB", 18.0));

        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(rectangle);
        getChildren().add(text1);
        getChildren().add(text2);
        getChildren().add(nameList);
        getChildren().add(scoreList);
        getChildren().add(btnList);
        getChildren().add(btnBack);
        getChildren().add(profilrbtn);
        getChildren().add(text3);

    }
}
