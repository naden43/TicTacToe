package tictactoeclient;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import playerhelper.PlayerDetails;

public class ShowRecVideo extends AnchorPane {

    protected final ImageView person2_view;
    protected final Text turn_txt;
    protected final ImageView person1_view;
    protected final Button resetBtn;
    protected final Button exitBtn;
    Button[] btn;
    char[] board = new char[9];
    protected final Label xLabel;
    protected final Label oLabel;
    protected final Text Person2Name;
    protected final Text person1Name;
    protected Thread th;
    PlayerDetails player;

    public ShowRecVideo(Stage stage, String selectedRecord, PlayerDetails player) {
        this.player = player;

        person2_view = new ImageView();
        turn_txt = new Text();
        person1_view = new ImageView();
        resetBtn = new Button();
        exitBtn = new Button();
        btn = new Button[9];
        for (int i = 0; i < 9; i++) {
            btn[i] = new Button();
        }
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
        setStyle("-fx-background-color: #42C4F7;");

        person2_view.setFitHeight(105.0);
        person2_view.setFitWidth(103.0);
        person2_view.setLayoutX(546.0);
        person2_view.setLayoutY(133.0);
        person2_view.setPickOnBounds(true);
        person2_view.setPreserveRatio(true);
        person2_view.setImage(new Image(getClass().getResource("Images/man2.png").toExternalForm()));

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

        resetBtn.setLayoutX(179.0);
        resetBtn.setLayoutY(407.0);
        resetBtn.setMnemonicParsing(false);
        resetBtn.setPrefHeight(32.0);
        resetBtn.setPrefWidth(122.0);
        resetBtn.setStyle("-fx-background-radius: 20; -fx-background-color: #00886D;");
        resetBtn.setText("Reset");
        resetBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        resetBtn.setFont(new Font("Berlin Sans FB", 20.0));
       resetBtn.setOnAction(e -> {
            th.interrupt(); // Stop the thread
            resetBoard();   // Clear the board and update UI
            resetBtn.setDisable(true); // Disable the button again until the game restarts
            exitBtn.setDisable(true);
            startGameThread(selectedRecord); // Start the game thread again
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
        exitBtn.setOnAction((e) -> {
            stage.setScene(new Scene(new RecordList(stage, player)));
        });

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
        Person2Name.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        Person2Name.setWrappingWidth(168.279296875);
        Person2Name.setFont(new Font(26.0));

        person1Name.setLayoutX(20.0);
        person1Name.setLayoutY(267.0);
        person1Name.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        person1Name.setStrokeWidth(0.0);
        person1Name.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        person1Name.setWrappingWidth(168.279296875);
        person1Name.setFont(new Font(26.0));

        resetBtn.setDisable(true);
        exitBtn.setDisable(true);

        getChildren().add(person2_view);
        getChildren().add(turn_txt);
        getChildren().add(person1_view);
        getChildren().add(resetBtn);
        getChildren().add(exitBtn);
        for (int i = 0; i < 9; i++) {
            getChildren().add(btn[i]);
        }
        getChildren().add(xLabel);
        getChildren().add(oLabel);
        getChildren().add(Person2Name);
        getChildren().add(person1Name);

        startGameThread(selectedRecord);
    }

    private void startGameThread(String selectedRecord) {
        th = new Thread(() -> {
            String[] line = selectedRecord.split("\n");
            boolean tr = true;
            for (String game : line) {
                String[] step = game.split(" ");
                tr = !tr;
                final boolean t = tr;
                Platform.runLater(() -> {
                    turn_txt.setText(step[0] + " Turn");
                    if (t) {
                        person1Name.setText(step[0]);
                    } else {
                        Person2Name.setText(step[0]);
                    }
                    btn[Integer.valueOf(step[4])].setText(step[2]);
                    board[Integer.valueOf(step[4])] = step[2].charAt(0);
                });
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ShowRecVideo.class.getName()).log(Level.SEVERE, null, ex);
                    Thread.currentThread().interrupt(); // Re-interrupt the thread
                }
                GameLogic.checkWin(board, btn);
            }
            Platform.runLater(() -> {
                resetBtn.setDisable(false);
                exitBtn.setDisable(false);
            });
        });

        th.start();
    }

     private void resetBoard() {
        // Clear the board and update UI
        for (int i = 0; i < 9; i++) {
            btn[i].setText("");
            board[i] = '\0';
        }

        // Reset player names and turn text
        person1Name.setText("");
        Person2Name.setText("");
        turn_txt.setText("");

        // Add code to reset any highlighting (modify as needed based on your implementation)
        for (int i = 0; i < 9; i++) {
            btn[i].setStyle("-fx-background-radius: 15;"); // Reset button style
        }
         for (int i = 0; i < 9; i++) {
            btn[i].setText("");
            board[i] = '\0';
            btn[i].setDisable(false); // Enable all buttons
        }
    }
}
