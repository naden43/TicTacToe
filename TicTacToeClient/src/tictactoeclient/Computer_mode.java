package tictactoeclient;

import java.util.Random;
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

public class Computer_mode extends BorderPane {

    protected final Pane pane;
    protected final ImageView computer_view;
    protected final Text cScore;
    protected final Text turn_txt;
    protected final ImageView person1_view;
    protected final Text p1Score;
    protected final Button resetBtn;
    protected final Button exitBtn;
    Button[] btn;
    char[] board = new char[9];
    boolean personTurn = true;
    Random randomPlay = new Random();


    public Computer_mode(Stage stage) {

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

        computer_view.setFitHeight(80.0);
        computer_view.setFitWidth(92.0);
        computer_view.setLayoutX(475.0);
        computer_view.setLayoutY(53.0);
        computer_view.setPickOnBounds(true);
        computer_view.setPreserveRatio(true);
        computer_view.setImage(new Image(getClass().getResource("Images/desktop.png").toExternalForm()));

        cScore.setLayoutX(479.0);
        cScore.setLayoutY(167.0);
        cScore.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        cScore.setStrokeWidth(0.0);
        cScore.setText("0");
        cScore.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        cScore.setWrappingWidth(72.98307228088379);
        cScore.setFont(new Font("Berlin Sans FB", 20.0));

        turn_txt.setFill(javafx.scene.paint.Color.WHITE);
        turn_txt.setLayoutX(203.0);
        turn_txt.setLayoutY(80.0);
        turn_txt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        turn_txt.setStrokeWidth(0.0);
        turn_txt.setText("Computer Turn");
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

        resetBtn.setLayoutX(128.0);
        resetBtn.setLayoutY(300.0);
        resetBtn.setMnemonicParsing(false);
        resetBtn.setPrefHeight(32.0);
        resetBtn.setPrefWidth(122.0);
        resetBtn.setStyle("-fx-background-radius: 20; -fx-background-color: #00886D;");
        resetBtn.setText("Reset");
        resetBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        resetBtn.setFont(new Font("Berlin Sans FB", 20.0));

        exitBtn.setLayoutX(330.0);
        exitBtn.setLayoutY(300.0);
        exitBtn.setMnemonicParsing(false);
        exitBtn.setPrefHeight(32.0);
        exitBtn.setPrefWidth(122.0);
        exitBtn.setStyle("-fx-background-radius: 20; -fx-background-color: CE091E;");
        exitBtn.setText("Exit");
        exitBtn.setTextFill(javafx.scene.paint.Color.WHITE);
        exitBtn.setFont(new Font("Berlin Sans FB", 20.0));
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

    }
    public void handleButtonClick(int index) {
        if (board[index] == '\0') {
            if (personTurn) {
                btn[index].setText("X");
                board[index] = 'X';
            personTurn = false;
            turn_txt.setText("Computer Turn");
            computerPlayRandom();
            }
        }
    }
    public void computerPlayRandom(){
        int emptyCells = 0;
        for(char cell : board){
            if(cell == '\0')
                emptyCells ++;
        }
        if(emptyCells >0){
            int randomIndex;
            do{
                randomIndex = randomPlay.nextInt(9);
            }while(board[randomIndex] != '\0');
            board[randomIndex]= 'O';
            btn[randomIndex].setText("O");
            personTurn = true;
            turn_txt.setText("Your Turn");
        }
    }
}
