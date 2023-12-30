package tictactoeclient;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public abstract class ShowRecVideo extends BorderPane {

    protected final Pane pane;
    protected final ImageView person2_view;
    protected final Text p2Score;
    protected final Text turn_txt;
    protected final ImageView person1_view;
    protected final Text p1Score;
    protected final Button btn1;
    protected final Button btn2;
    protected final Button resetBtn;
    protected final Button exitBtn;
    protected final Button btn3;
    protected final Button btn4;
    protected final Button btn5;
    protected final Button btn6;
    protected final Button btn8;
    protected final Button btn7;
    protected final Button btn9;
    protected final Label xLabel;
    protected final Label oLabel;
    protected final Text Person2Name;
    protected final Text person1Name;

    public ShowRecVideo() {

        pane = new Pane();
        person2_view = new ImageView();
        p2Score = new Text();
        turn_txt = new Text();
        person1_view = new ImageView();
        p1Score = new Text();
        btn1 = new Button();
        btn2 = new Button();
        resetBtn = new Button();
        exitBtn = new Button();
        btn3 = new Button();
        btn4 = new Button();
        btn5 = new Button();
        btn6 = new Button();
        btn8 = new Button();
        btn7 = new Button();
        btn9 = new Button();
        xLabel = new Label();
        oLabel = new Label();
        Person2Name = new Text();
        person1Name = new Text();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(700.0);

        BorderPane.setAlignment(pane, javafx.geometry.Pos.CENTER);
        pane.setBlendMode(javafx.scene.effect.BlendMode.SRC_ATOP);
        pane.setDepthTest(javafx.scene.DepthTest.DISABLE);
        pane.setPrefHeight(200.0);
        pane.setPrefWidth(200.0);
        pane.setStyle("-fx-background-color: #42C4F7;");

        person2_view.setFitHeight(105.0);
        person2_view.setFitWidth(103.0);
        person2_view.setLayoutX(546.0);
        person2_view.setLayoutY(133.0);
        person2_view.setPickOnBounds(true);
        person2_view.setPreserveRatio(true);
        person2_view.setImage(new Image(getClass().getResource("Images/man2.png").toExternalForm()));

        p2Score.setLayoutX(563.0);
        p2Score.setLayoutY(298.0);
        p2Score.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        p2Score.setStrokeWidth(0.0);
        p2Score.setText("0");
        p2Score.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        p2Score.setWrappingWidth(72.98307228088379);
        p2Score.setFont(new Font("Berlin Sans FB", 26.0));

        turn_txt.setFill(javafx.scene.paint.Color.WHITE);
        turn_txt.setLayoutX(240.0);
        turn_txt.setLayoutY(87.0);
        turn_txt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        turn_txt.setStrokeWidth(0.0);
        turn_txt.setText("X-Player Turn");
        turn_txt.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        turn_txt.setWrappingWidth(219.9830722808838);
        turn_txt.setFont(new Font("Berlin Sans FB", 31.0));

        person1_view.setFitHeight(105.0);
        person1_view.setFitWidth(103.0);
        person1_view.setLayoutX(53.0);
        person1_view.setLayoutY(133.0);
        person1_view.setPickOnBounds(true);
        person1_view.setPreserveRatio(true);
        person1_view.setImage(new Image(getClass().getResource("Images/man1.png").toExternalForm()));

        p1Score.setLayoutX(71.0);
        p1Score.setLayoutY(299.0);
        p1Score.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        p1Score.setStrokeWidth(0.0);
        p1Score.setText("6");
        p1Score.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        p1Score.setWrappingWidth(66.48697900772095);
        p1Score.setFont(new Font("Berlin Sans FB", 26.0));

        btn1.setContentDisplay(javafx.scene.control.ContentDisplay.BOTTOM);
        btn1.setLayoutX(242.0);
        btn1.setLayoutY(189.0);
        btn1.setMnemonicParsing(false);
        btn1.setPrefHeight(55.0);
        btn1.setPrefWidth(70.0);
        btn1.setStyle("-fx-background-radius: 15; -fx-background-color: #D0E7F3;");
        btn1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn1.setOpaqueInsets(new Insets(0.0));
        btn1.setFont(new Font(25.0));

        btn2.setContentDisplay(javafx.scene.control.ContentDisplay.BOTTOM);
        btn2.setLayoutX(315.0);
        btn2.setLayoutY(189.0);
        btn2.setMnemonicParsing(false);
        btn2.setPrefHeight(55.0);
        btn2.setPrefWidth(70.0);
        btn2.setStyle("-fx-background-radius: 15; -fx-background-color: F6FBFE;");
        btn2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn2.setOpaqueInsets(new Insets(0.0));

        resetBtn.setLayoutX(179.0);
        resetBtn.setLayoutY(407.0);
        resetBtn.setMnemonicParsing(false);
        resetBtn.setPrefHeight(32.0);
        resetBtn.setPrefWidth(122.0);
        resetBtn.setStyle("-fx-background-radius: 20; -fx-background-color: #00886D;");
        resetBtn.setText("Reset");
        resetBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        resetBtn.setFont(new Font("Berlin Sans FB", 20.0));

        exitBtn.setLayoutX(399.0);
        exitBtn.setLayoutY(407.0);
        exitBtn.setMnemonicParsing(false);
        exitBtn.setPrefHeight(32.0);
        exitBtn.setPrefWidth(122.0);
        exitBtn.setStyle("-fx-background-radius: 20; -fx-background-color: CE091E;");
        exitBtn.setText("Exit");
        exitBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        exitBtn.setFont(new Font("Berlin Sans FB", 20.0));

        btn3.setContentDisplay(javafx.scene.control.ContentDisplay.BOTTOM);
        btn3.setLayoutX(388.0);
        btn3.setLayoutY(189.0);
        btn3.setMnemonicParsing(false);
        btn3.setPrefHeight(55.0);
        btn3.setPrefWidth(70.0);
        btn3.setStyle("-fx-background-radius: 15; -fx-background-color: #D0E7F3;");
        btn3.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn3.setOpaqueInsets(new Insets(0.0));
        btn3.setFont(new Font(25.0));

        btn4.setContentDisplay(javafx.scene.control.ContentDisplay.BOTTOM);
        btn4.setLayoutX(242.0);
        btn4.setLayoutY(248.0);
        btn4.setMnemonicParsing(false);
        btn4.setPrefHeight(55.0);
        btn4.setPrefWidth(70.0);
        btn4.setStyle("-fx-background-radius: 15; -fx-background-color: F6FBFE;");
        btn4.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn4.setOpaqueInsets(new Insets(0.0));

        btn5.setContentDisplay(javafx.scene.control.ContentDisplay.BOTTOM);
        btn5.setLayoutX(315.0);
        btn5.setLayoutY(248.0);
        btn5.setMnemonicParsing(false);
        btn5.setPrefHeight(55.0);
        btn5.setPrefWidth(70.0);
        btn5.setStyle("-fx-background-radius: 15; -fx-background-color: #D0E7F3;");
        btn5.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn5.setOpaqueInsets(new Insets(0.0));
        btn5.setFont(new Font(25.0));

        btn6.setContentDisplay(javafx.scene.control.ContentDisplay.BOTTOM);
        btn6.setLayoutX(388.0);
        btn6.setLayoutY(248.0);
        btn6.setMnemonicParsing(false);
        btn6.setPrefHeight(55.0);
        btn6.setPrefWidth(70.0);
        btn6.setStyle("-fx-background-radius: 15; -fx-background-color: F6FBFE;");
        btn6.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn6.setOpaqueInsets(new Insets(0.0));

        btn8.setContentDisplay(javafx.scene.control.ContentDisplay.BOTTOM);
        btn8.setLayoutX(315.0);
        btn8.setLayoutY(307.0);
        btn8.setMnemonicParsing(false);
        btn8.setPrefHeight(55.0);
        btn8.setPrefWidth(70.0);
        btn8.setStyle("-fx-background-radius: 15; -fx-background-color: F6FBFE;");
        btn8.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn8.setOpaqueInsets(new Insets(0.0));

        btn7.setContentDisplay(javafx.scene.control.ContentDisplay.BOTTOM);
        btn7.setLayoutX(242.0);
        btn7.setLayoutY(307.0);
        btn7.setMnemonicParsing(false);
        btn7.setPrefHeight(55.0);
        btn7.setPrefWidth(70.0);
        btn7.setStyle("-fx-background-radius: 15; -fx-background-color: #D0E7F3;");
        btn7.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn7.setOpaqueInsets(new Insets(0.0));
        btn7.setFont(new Font(25.0));

        btn9.setContentDisplay(javafx.scene.control.ContentDisplay.BOTTOM);
        btn9.setLayoutX(388.0);
        btn9.setLayoutY(307.0);
        btn9.setMnemonicParsing(false);
        btn9.setPrefHeight(55.0);
        btn9.setPrefWidth(70.0);
        btn9.setStyle("-fx-background-radius: 15; -fx-background-color: #D0E7F3;");
        btn9.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        btn9.setOpaqueInsets(new Insets(0.0));
        btn9.setFont(new Font(25.0));

        xLabel.setLayoutX(97.0);
        xLabel.setLayoutY(94.0);
        xLabel.setText("X");
        xLabel.setFont(new Font("Berlin Sans FB", 25.0));

        oLabel.setLayoutX(590.0);
        oLabel.setLayoutY(94.0);
        oLabel.setText("O");
        oLabel.setFont(new Font("Berlin Sans FB", 25.0));

        Person2Name.setLayoutX(515.0);
        Person2Name.setLayoutY(267.0);
        Person2Name.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        Person2Name.setStrokeWidth(0.0);
        Person2Name.setText("O-Player");
        Person2Name.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        Person2Name.setWrappingWidth(168.279296875);
        Person2Name.setFont(new Font(26.0));

        person1Name.setLayoutX(20.0);
        person1Name.setLayoutY(267.0);
        person1Name.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        person1Name.setStrokeWidth(0.0);
        person1Name.setText("X-Player");
        person1Name.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        person1Name.setWrappingWidth(168.279296875);
        person1Name.setFont(new Font(26.0));
        setCenter(pane);

        pane.getChildren().add(person2_view);
        pane.getChildren().add(p2Score);
        pane.getChildren().add(turn_txt);
        pane.getChildren().add(person1_view);
        pane.getChildren().add(p1Score);
        pane.getChildren().add(btn1);
        pane.getChildren().add(btn2);
        pane.getChildren().add(resetBtn);
        pane.getChildren().add(exitBtn);
        pane.getChildren().add(btn3);
        pane.getChildren().add(btn4);
        pane.getChildren().add(btn5);
        pane.getChildren().add(btn6);
        pane.getChildren().add(btn8);
        pane.getChildren().add(btn7);
        pane.getChildren().add(btn9);
        pane.getChildren().add(xLabel);
        pane.getChildren().add(oLabel);
        pane.getChildren().add(Person2Name);
        pane.getChildren().add(person1Name);

    }
}
