package tictactoeclient;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Local_mode extends BorderPane {

    protected final Pane pane;
    protected final ImageView person2_view;
    protected final Text p2Score;
    protected final Text turn_txt;
    protected final ImageView person1_view;
    protected final Text p1Score;
    protected final Button playAgainBtn;
    protected final Button exitBtn;
    protected final ImageView video_record;
    Button[] btn;
    char[] board = new char[9];
    boolean personTurn = true;

    public Local_mode(Stage stage) {

        pane = new Pane();
        person2_view = new ImageView();
        p2Score = new Text();
        turn_txt = new Text();
        person1_view = new ImageView();
        p1Score = new Text();
         btn = new Button[9];
        for (int i = 0; i < 9; i++) {
            btn[i] = new Button();
        }
        playAgainBtn = new Button();
        exitBtn = new Button();
        video_record = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        BorderPane.setAlignment(pane, javafx.geometry.Pos.CENTER);
        pane.setBlendMode(javafx.scene.effect.BlendMode.SRC_ATOP);
        pane.setDepthTest(javafx.scene.DepthTest.DISABLE);
        pane.setPrefHeight(200.0);
        pane.setPrefWidth(200.0);
        pane.setStyle("-fx-background-color: #42C4F7;");

        person2_view.setFitHeight(80.0);
        person2_view.setFitWidth(92.0);
        person2_view.setLayoutX(475.0);
        person2_view.setLayoutY(53.0);
        person2_view.setPickOnBounds(true);
        person2_view.setPreserveRatio(true);
        person2_view.setImage(new Image(getClass().getResource("Images/man2.png").toExternalForm()));

        p2Score.setLayoutX(479.0);
        p2Score.setLayoutY(167.0);
        p2Score.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        p2Score.setStrokeWidth(0.0);
        p2Score.setText("0");
        p2Score.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        p2Score.setWrappingWidth(72.98307228088379);
        p2Score.setFont(new Font("Berlin Sans FB", 20.0));

        turn_txt.setFill(javafx.scene.paint.Color.WHITE);
        turn_txt.setLayoutX(203.0);
        turn_txt.setLayoutY(86.0);
        turn_txt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        turn_txt.setStrokeWidth(0.0);
        turn_txt.setText("Your Turn");
        turn_txt.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        turn_txt.setWrappingWidth(174.9830722808838);
        turn_txt.setFont(new Font("Berlin Sans FB", 26.0));

        person1_view.setFitHeight(80.0);
        person1_view.setFitWidth(92.0);
        person1_view.setLayoutX(33.0);
        person1_view.setLayoutY(53.0);
        person1_view.setPickOnBounds(true);
        person1_view.setPreserveRatio(true);
        person1_view.setImage(new Image(getClass().getResource("Images/man1.png").toExternalForm()));

        p1Score.setLayoutX(45.0);
        p1Score.setLayoutY(165.0);
        p1Score.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        p1Score.setStrokeWidth(0.0);
        p1Score.setText("6");
        p1Score.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        p1Score.setWrappingWidth(55.48697900772095);
        p1Score.setFont(new Font("Berlin Sans FB", 20.0));

        for (int i = 0; i < 9; i++) {
            btn[i].setContentDisplay(javafx.scene.control.ContentDisplay.BOTTOM);
            btn[i].setMnemonicParsing(false);
            btn[i].setPrefHeight(42.0);
            btn[i].setPrefWidth(66.0);
            btn[i].setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
            btn[i].setOpaqueInsets(new Insets(0.0));
            if (i % 2 == 0) {
                btn[i].setStyle("-fx-background-radius: 15; -fx-background-color: #D0E7F3;");
            } else {
                btn[i].setStyle("-fx-background-radius: 15; -fx-background-color: F6FBFE;");
            }
            if (i < 3) {
                btn[i].setLayoutY(130.0);
            } else if (i < 6) {
                btn[i].setLayoutY(176.0);
            } else {
                btn[i].setLayoutY(222.0);
            }
            switch (i % 3) {
                case 0:
                    btn[i].setLayoutX(189.0);
                    break;
                case 1:
                    btn[i].setLayoutX(257.0);
                    break;
                default:
                    btn[i].setLayoutX(325.0);
                    break;
            }
        }
        for (int i = 0; i < 9; i++) {
            int index = i;
            btn[i].setOnAction((ActionEvent event) -> {
                handleButtonClick(index);
            });
        }


        playAgainBtn.setLayoutX(128.0);
        playAgainBtn.setLayoutY(300.0);
        playAgainBtn.setMnemonicParsing(false);
        playAgainBtn.setPrefHeight(37.0);
        playAgainBtn.setPrefWidth(122.0);
        playAgainBtn.setStyle("-fx-background-radius: 20; -fx-background-color: #00886D;");
        playAgainBtn.setText("Play Again");
        playAgainBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        playAgainBtn.setFont(new Font("Berlin Sans FB", 20.0));

        exitBtn.setLayoutX(330.0);
        exitBtn.setLayoutY(300.0);
        exitBtn.setMnemonicParsing(false);
        exitBtn.setPrefHeight(37.0);
        exitBtn.setPrefWidth(122.0);
        exitBtn.setStyle("-fx-background-radius: 20; -fx-background-color: CE091E;");
        exitBtn.setText("Exit");
        exitBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        exitBtn.setFont(new Font("Berlin Sans FB", 20.0));

        video_record.setFitHeight(40.0);
        video_record.setFitWidth(50.0);
        video_record.setLayoutX(270.0);
        video_record.setLayoutY(14.0);
        video_record.setPickOnBounds(true);
        video_record.setPreserveRatio(true);
        video_record.setImage(new Image(getClass().getResource("Images/video.png").toExternalForm()));
        setCenter(pane);

        pane.getChildren().add(person2_view);
        pane.getChildren().add(p2Score);
        pane.getChildren().add(turn_txt);
        pane.getChildren().add(person1_view);
        pane.getChildren().add(p1Score);
        for (int i = 0; i < 9; i++) {
            pane.getChildren().add(btn[i]);
        }
        pane.getChildren().add(playAgainBtn);
        pane.getChildren().add(exitBtn);
        pane.getChildren().add(video_record);

    }
    public void handleButtonClick(int index) {
        if (board[index] == '\0') {
            if (personTurn) {
                btn[index].setText("X");
                board[index] = 'X';
            } else {
                btn[index].setText("O");
                board[index] = 'O';
            }
            personTurn = !personTurn;
            turn_txt.setText(personTurn ? "Your Turn" : "Computer Turn");
        }
    }
}
