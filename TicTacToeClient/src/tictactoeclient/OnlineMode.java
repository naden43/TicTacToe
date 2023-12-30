package tictactoeclient;

import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import playerhelper.PlayerDetails;
//import static tictactoeclient.ChoosePlayer.alert;
import static tictactoeclient.SignIn.stage;

public class OnlineMode extends BorderPane {

    protected final Pane pane;
    protected final ImageView person2_view;
    static protected final Text p2Score;
    static protected final Text turn_txt;
    protected final ImageView person1_view;
    static protected final Text p1Score;
    static Button[] btn;
    static char[] board = new char[9];
    static boolean personTurn;
    static protected final Button resetBtn;
    protected final Button exitBtn;
    protected final Label xLabel;
    protected final Label oLabel;
    protected final Text Person2Name;
    protected final Text person1Name;
    protected final ImageView videoRec;
    protected final Text txtTime;
    static Gson gson;
    static String player1, player2, playerx;
    public static char myChar;
    static int cellsCounter = 0;
    public static int score1, score2;
    static boolean gameIsOn;
    static Alert alert;
    static Timeline timeline;

    static {
        gson = new Gson();
        turn_txt = new Text();
        score1 = 0;
        score2 = 0;
        p2Score = new Text();
        p1Score = new Text();
        gameIsOn = true;
        resetBtn = new Button();

    }
    static GameLogic game = new GameLogic();

    public OnlineMode(Stage stage, String player1, String player2, String playerx) {

        this.player1 = player1;
        this.player2 = player2;
        this.playerx = playerx;
        if (player1.equals(playerx)) {
            personTurn = true;
            myChar = 'X';
        } else {
            myChar = 'O';
            personTurn = false;
        }
        pane = new Pane();
        person2_view = new ImageView();

        person1_view = new ImageView();

        btn = new Button[9];
        for (int i = 0; i < 9; i++) {
            btn[i] = new Button();
        }
        exitBtn = new Button();
        xLabel = new Label();
        oLabel = new Label();
        Person2Name = new Text();
        person1Name = new Text();
        videoRec = new ImageView();
        txtTime = new Text();

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
        p2Score.setText(score2 + "");
        p2Score.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        p2Score.setWrappingWidth(72.98307228088379);
        p2Score.setFont(new Font("Berlin Sans FB", 26.0));

        turn_txt.setFill(javafx.scene.paint.Color.WHITE);
        turn_txt.setLayoutX(240.0);
        turn_txt.setLayoutY(87.0);
        turn_txt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        turn_txt.setStrokeWidth(0.0);
        turn_txt.setText(playerx);
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
        p1Score.setText(score1 + "");
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
                handleButtonClick(index);
            });
        }

        resetBtn.setLayoutX(179.0);
        resetBtn.setLayoutY(407.0);
        resetBtn.setMnemonicParsing(false);
        resetBtn.setPrefHeight(32.0);
        resetBtn.setPrefWidth(140.0);
        resetBtn.setStyle("-fx-background-radius: 20; -fx-background-color: #00886D;");
        resetBtn.setText("Play Again");
        resetBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        resetBtn.setFont(new Font("Berlin Sans FB", 20.0));
        resetBtn.setDisable(true);

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
        if (!personTurn) {
            Person2Name.setText(player1);
        } else {
            Person2Name.setText(player2);
        }
        Person2Name.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        Person2Name.setWrappingWidth(168.279296875);
        Person2Name.setFont(new Font(26.0));

        person1Name.setLayoutX(20.0);
        person1Name.setLayoutY(267.0);
        person1Name.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        person1Name.setStrokeWidth(0.0);
        if (!personTurn) {
            person1Name.setText(player2);
        } else {
            person1Name.setText(player1);
        }
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

        txtTime.setLayoutX(303.0);
        txtTime.setLayoutY(129.0);
        txtTime.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        txtTime.setStrokeWidth(0.0);
        txtTime.setText("00 : 00");
        txtTime.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        txtTime.setWrappingWidth(92.05078125);
        txtTime.setFont(new Font("Berlin Sans FB", 21.0));
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
        pane.getChildren().add(txtTime);

        //Timeline timerLabel = new Label("00:00:00");
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

            int seconds = 0;

            public void handle(ActionEvent event) {

                seconds++;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = String.format("%02d:%02d", minutes, secs);
                txtTime.setText(time);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int ret = GameLogic.checkExitInOnline(stage);
                if (ret == 1) {
                    ArrayList msg = new ArrayList();
                    msg.add(8);
                    msg.add(gameIsOn);
                    TicTacToeClient.playerHandler.sendRequest(gson.toJson(msg));
                }
            }
        });

        resetBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                resetBtn.setDisable(true);
                ArrayList msg = new ArrayList();
                msg.add(10);
                TicTacToeClient.playerHandler.sendRequest(gson.toJson(msg));
                showAlertWithTimeout();
            }
        });

    }

    public void handleButtonClick(int index) {
        if (board[index] == '\0') {
            if (personTurn) {
                btn[index].setText(myChar + "");
                board[index] = myChar;
                cellsCounter++;
                ArrayList msg = new ArrayList();
                msg.add(6);
                msg.add(index);
                TicTacToeClient.playerHandler.sendRequest(gson.toJson(msg));
                int result = GameLogic.checkWin(board, btn);
                if (result == 1 || result == 2) {
                    resetBtn.setDisable(false);
                }
                showWin(result);
                if (result == 0 && cellsCounter < 9) {
                    turn_txt.setText(player2 + "Turn");
                }
            }

        }
    }

    public static void putTheCharPlay(double index) {
        cellsCounter++;
        if (myChar == 'X') {
            btn[(int) index].setText("O");
            board[(int) index] = 'O';
        } else {
            btn[(int) index].setText("X");
            board[(int) index] = 'X';
        }
        int result = GameLogic.checkWin(board, btn);
        if (result == 1 || result == 2) {
            resetBtn.setDisable(false);
        }
        showWin(result);
        if (result == 0 && cellsCounter < 9) {
            turn_txt.setText(player1 + "Turn");
        }
        //personTurn = !personTurn;
    }

    public static void showWin(int winner) {

        if (winner == 1) {
            if (myChar == 'X') {
                try {
                    score1++;
                    p1Score.setText(score1 + "");
                    turn_txt.setText("You Win");
                    game.setWinnerVideo(stage);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(OnlineMode.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                score1++;
                p1Score.setText(score1 + "");
                turn_txt.setText("You Lose");
                game.setLoserVideo(stage);
            }
            gameIsOn = false;
        } else if (winner == 2) {
            score2++;
            p2Score.setText(score2 + "");
            if (myChar == 'O') {
                try {
                    turn_txt.setText("You Win");
                    game.setWinnerVideo(stage);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(OnlineMode.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                turn_txt.setText("You Lose");
                game.setLoserVideo(stage);
            }
            gameIsOn = false;
        } else if (winner == 0 && cellsCounter == 9) {
            turn_txt.setText("Draw.......");
            game.setDrawVideo(stage);
            gameIsOn = false;
        } else {
            personTurn = !personTurn;
        }
    }

    public static void backToChoosePlayer(ArrayList<PlayerDetails> players) {
        ArrayList msg = new ArrayList();
        msg.add(9);
        if (myChar == 'O') {

            msg.add(score2);
            System.out.println(score2 + "o");

        } else {

            msg.add(score1);
            System.out.println(score1 + "x");

        }
        TicTacToeClient.playerHandler.sendRequest(gson.toJson(msg));
        gameIsOn = true;
        personTurn = true;
        score1 = 0;
        score2 = 0;
        myChar = ' ';
        cellsCounter = 0;
        btn = new Button[9];
        board = new char[9];
        stage.setScene(new Scene(new ChoosePlayer(stage, players)));
    }

    private static void showAlertWithTimeout() {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("send invitation");
        alert.setHeaderText("sending request to " + player2);

        // Set up a timeline to close the alert after 3 seconds
        timeline = new Timeline(new KeyFrame(Duration.seconds(30), e -> alert.close()));
        timeline.setCycleCount(1); // Run once

        // Show the alert and start the timeline
        alert.show();
        timeline.play();
    }

    public static void ResetGame(double ind) {

        if(ind == 0){ // if you are who send a request
        alert.close();
        timeline.stop();
        }
        resetBtn.setDisable(true);
        gameIsOn = true;
        if(myChar=='X')
        {
            turn_txt.setText(player1);
           personTurn = true; 
        }
        else
        {
           turn_txt.setText(player2);
            personTurn = false;
        }
        
        cellsCounter = 0;
        for (int i = 0; i < 9; i++) {
            btn[i].setText("");
            if (i % 2 == 0) {
                btn[i].setStyle("-fx-background-radius: 15; -fx-background-color: #D0E7F3;");
                btn[i].setDisable(false);

            } else {
                btn[i].setStyle("-fx-background-radius: 15; -fx-background-color: F6FBFE;");
                btn[i].setDisable(false);

            }
        }
        board = new char[9];
    }
}
