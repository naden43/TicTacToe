package tictactoeclient;

import java.net.MalformedURLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import static javafx.scene.layout.Region.USE_PREF_SIZE;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ComputerMode extends BorderPane {

    protected final Pane pane;
    protected final ImageView computer_view;
    protected final Text cScore;
    protected final Text turn_txt;
    protected final ImageView person1_view;
    protected final Text p1Score;
    Button[] btn;
    char[] board = new char[9];
    boolean personTurn = true;
    Random randomPlay = new Random();
    protected final Button resetBtn;
    protected final Button exitBtn;
    protected final Label xLabel;
    protected final Label oLabel;
    static Integer computerScore = 0;
    static Integer personScore = 0;
    Stage stage;
    int clickedBtnCounter = 0;

    public ComputerMode(Stage stage) {

        this.stage = stage;
        pane = new Pane();
        computer_view = new ImageView();
        cScore = new Text();
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

        computer_view.setFitHeight(105.0);
        computer_view.setFitWidth(103.0);
        computer_view.setLayoutX(546.0);
        computer_view.setLayoutY(133.0);
        computer_view.setPickOnBounds(true);
        computer_view.setPreserveRatio(true);
        computer_view.setImage(new Image(getClass().getResource("Images/desktop.png").toExternalForm()));

        cScore.setLayoutX(561.0);
        cScore.setLayoutY(285.0);
        cScore.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        cScore.setStrokeWidth(0.0);
        cScore.setText("0");
        cScore.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        cScore.setWrappingWidth(72.98307228088379);
        cScore.setFont(new Font("Berlin Sans FB", 26.0));
        cScore.setText(computerScore.toString());

        turn_txt.setFill(javafx.scene.paint.Color.WHITE);
        turn_txt.setLayoutX(240.0);
        turn_txt.setLayoutY(87.0);
        turn_txt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        turn_txt.setStrokeWidth(0.0);
        turn_txt.setText("Your Turn");
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
        p1Score.setLayoutY(283.0);
        p1Score.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        p1Score.setStrokeWidth(0.0);
        p1Score.setText("0");
        p1Score.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        p1Score.setWrappingWidth(66.48697900772095);
        p1Score.setFont(new Font("Berlin Sans FB", 26.0));
        p1Score.setText(personScore.toString());

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

                } catch (MalformedURLException ex) {
                    Logger.getLogger(ComputerMode.class.getName()).log(Level.SEVERE, null, ex);
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
        resetBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(new Scene(new ComputerMode(stage)));

            }
        });

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
        setCenter(pane);

        pane.getChildren().add(computer_view);
        pane.getChildren().add(cScore);
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

        exitBtn.setOnAction(e -> {
            GameLogic.checkExit(stage);
        });
        
    }

    public void handleButtonClick(int index) throws MalformedURLException {
        int currentStatus = 0;
        if(clickedBtnCounter == 9) return;
        if (board[index] == '\0') {
            if (personTurn) {
                btn[index].setText("X");
                board[index] = 'X';
                currentStatus = GameLogic.checkWin(board, btn);
                clickedBtnCounter++;
            }
            if (currentStatus == 0 && clickedBtnCounter <= 8) {
                turn_txt.setText("Computer Turn");
                personTurn = false;
                computerPlayRandom();
                currentStatus = GameLogic.checkWin(board, btn);
                clickedBtnCounter++;
            }
            
            turn_txt.setText("person Turn");
        }
        if (currentStatus == 1) {
            incrementPersonScore();
            p1Score.setText(personScore.toString());
            turn_txt.setText("You win");
            new GameLogic().setWinnerVideo(stage);
        } else if (currentStatus == 2) {
            incrementComputerScore();
            cScore.setText(computerScore.toString());
            turn_txt.setText("Computer wins");
            new GameLogic().setLoserVideo(stage);
        } else if (currentStatus == 0 && clickedBtnCounter == 9) {
            turn_txt.setText("Draw");
            new GameLogic().setDrawVideo(stage);
        }

    }

    /*public void handleButtonClick(int index) {
        if (board[index] == '\0') {
            if (personTurn) {
                btn[index].setText("X");
                board[index] = 'X';
                if (GameLogic.checkWin(board, btn)==1) {
                    personTurn = false;
                    turn_txt.setText("Computer Turn");
                    computerPlayRandom();
                    if (GameLogic.checkWin(board, btn) == 2) {
                        incrementComputerScore();
                        new GameLogic().setLoserVideo(stage);
                    }
                } else {
                    incrementPersonScore();
                    try {
                        new GameLogic().setWinnerVideo(stage);
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(ComputerMode.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }*/
    public void computerPlayRandom() {
        int emptyCells = 0;
        for (char cell : board) {
            if (cell == '\0') {
                emptyCells++;
            }
        }
        if (emptyCells > 0) {
            int randomIndex;
            do {
                randomIndex = randomPlay.nextInt(9);
            } while (board[randomIndex] != '\0');
            board[randomIndex] = 'O';
            btn[randomIndex].setText("O");
            personTurn = true;
            turn_txt.setText("Your Turn");
        }

    }

    public void incrementPersonScore() {
        personScore++;
    }

    public void incrementComputerScore() {
        computerScore++;
    }

}
