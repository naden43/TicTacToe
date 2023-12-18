package tictactoeclient;

import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class LocalMode extends BorderPane {

    protected final Pane pane;
    protected final ImageView person2_view;
    protected final Text p2Score;
    protected final Text turn_txt;
    protected final ImageView person1_view;
    protected final Text p1Score;
    protected final Button resetBtn;
    protected final Button exitBtn;
    Button[] btn;
    char[] board = new char[9];
    boolean personTurn = true;
    protected final Label xLabel;
    protected final Label oLabel;
    protected final Text Person2Name;
    protected final Text person1Name;
    protected final ImageView videoRec;
    Stage stage;
    private int clickedBtnCounter = 0;
    static Integer scorePlayer1 = 0 ;
    static Integer scorePlayer2 = 0 ;

    public LocalMode(Stage stage) {

        this.stage = stage;
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
        resetBtn = new Button();
        exitBtn = new Button();
        xLabel = new Label();
        oLabel = new Label();
        Person2Name = new Text();
        person1Name = new Text();
        videoRec = new ImageView();

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

        for (int i = 0; i < 9; i++) {
            btn[i].setContentDisplay(javafx.scene.control.ContentDisplay.BOTTOM);
            btn[i].setMnemonicParsing(false);
            btn[i].setPrefHeight(55.0);
            btn[i].setPrefWidth(70.0);
            btn[i].setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
            btn[i].setFont(new Font("Berlin Sans FB", 25.0));
            btn[i].setOpaqueInsets(new Insets(0.0));
            if (i % 2 == 0) {
                btn[i].setStyle("-fx-background-radius: 15; -fx-background-color: #D0E7F3;");
            } else {
                btn[i].setStyle("-fx-background-radius: 15; -fx-background-color: F6FBFE;");
            }
            if (i < 3) {
                btn[i].setLayoutY(189.0);
            } else if (i < 6) {
                btn[i].setLayoutY(248.0);
            } else {
                btn[i].setLayoutY(307.0);
            }
            switch (i % 3) {
                case 0:
                    btn[i].setLayoutX(242.0);
                    break;
                case 1:
                    btn[i].setLayoutX(315.0);
                    break;
                default:
                    btn[i].setLayoutX(388.0);
                    break;
            }
        }
        for (int i = 0; i < 9; i++) {
            int index = i;
            btn[i].setOnAction((ActionEvent event) -> {
                try {
                    handleButtonClick(index);
                    clickedBtnCounter++;
                } catch (MalformedURLException ex) {
                    Logger.getLogger(LocalMode.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }

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

        videoRec.setFitHeight(47.0);
        videoRec.setFitWidth(87.0);
        videoRec.setLayoutX(326.0);
        videoRec.setLayoutY(14.0);
        videoRec.setPickOnBounds(true);
        videoRec.setPreserveRatio(true);
        videoRec.setImage(new Image(getClass().getResource("Images/video.png").toExternalForm()));
        setCenter(pane);

        pane.getChildren().add(person2_view);
        pane.getChildren().add(p2Score);
        pane.getChildren().add(turn_txt);
        pane.getChildren().add(person1_view);
        pane.getChildren().add(p1Score);
        for (int i = 0; i < 9; i++) {
            pane.getChildren().add(btn[i]);
        }
        pane.getChildren().add(resetBtn);
        pane.getChildren().add(exitBtn);
        pane.getChildren().add(xLabel);
        pane.getChildren().add(oLabel);
        pane.getChildren().add(Person2Name);
        pane.getChildren().add(person1Name);
        pane.getChildren().add(videoRec);
        
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                stage.setScene(new Scene(new ChooseMode(stage)));
            }
        });
        
        resetBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(new Scene(new LocalMode(stage)));
            }
        });

        p1Score.setText(scorePlayer1.toString());
        p2Score.setText(scorePlayer2.toString());
    }

    public void handleButtonClick(int index) throws MalformedURLException {
        int currentStatus = 0;

        if (board[index] == '\0') {
            if (personTurn) {
                btn[index].setText("X");
                board[index] = 'X';
                currentStatus = GameLogic.checkWin(board, btn);
            } else {
                btn[index].setText("O");
                board[index] = 'O';
                currentStatus = GameLogic.checkWin(board, btn);
            }
            personTurn = !personTurn;
            turn_txt.setText(personTurn ? "X-Player Turn" : "O-Player Turn");
        }
        if (currentStatus == 1) {
            scorePlayer1++;
            turn_txt.setText("X-Player wins");
            new GameLogic().setWinnerVideo(stage);
            stage.setScene(new Scene(new LocalMode(stage)));
            

        } else if (currentStatus == 2) {
            scorePlayer2++;
            turn_txt.setText("O-Player wins");
            new GameLogic().setLoserVideo(stage);
            stage.setScene(new Scene(new LocalMode(stage)));
            
        }

    }
}
