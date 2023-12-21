/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import javafx.scene.control.Button;
import java.io.File;
import java.net.MalformedURLException;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import java.util.Optional;
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Button;
import javafx.scene.control.DialogEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author user
 */
public class GameLogic {

    static public int checkWin(char[] board, Button[] btn) // 1-3(rows) 4-6(columns) 7-8(diagonal)   1-x 2-0 3-noOne
    {
        boolean flagX = false;
        boolean flagO = false;
        //horizontal
        for (int i = 0; i < 9; i += 3) {
            if (board[i] == 'X' && board[i + 1] == 'X' && board[i + 2] == 'X') {
                flagX = true;
                int[] index = {i, i + 1, i + 2};
                highlightWinPlace(index, btn);
                break;
            }
            if (board[i] == 'O' && board[i + 1] == 'O' && board[i + 2] == 'O') {
                flagO = true;
                int[] index = {i, i + 1, i + 2};
                highlightWinPlace(index, btn);
                break;
            }
        }
        //vertical
        for (int i = 0; i < 3; i += 1) {
            if (board[i] == 'X' && board[i + 3] == 'X' && board[i + 6] == 'X') {
                flagX = true;
                int[] index = {i, i + 3, i + 6};
                highlightWinPlace(index, btn);
                break;
            }
            if (board[i] == 'O' && board[i + 3] == 'O' && board[i + 6] == 'O') {
                flagO = true;
                int[] index = {i, i + 3, i + 6};
                highlightWinPlace(index, btn);
                break;
            }
        }
        //diagonal
        if (board[0] == 'X' && board[4] == 'X' && board[8] == 'X') {
            flagX = true;
            int[] index = {0, 4, 8};
            highlightWinPlace(index, btn);

        } else if (board[0] == 'O' && board[4] == 'O' && board[8] == 'O') {
            flagO = true;
            int[] index = {0, 4, 8};
            highlightWinPlace(index, btn);

        } else if (board[2] == 'O' && board[4] == 'O' && board[6] == 'O') {
            flagO = true;
            int[] index = {2, 4, 6};
            highlightWinPlace(index, btn);

        } else if (board[2] == 'X' && board[4] == 'X' && board[6] == 'X') {
            flagX = true;
            int[] index = {2, 4, 6};
            highlightWinPlace(index, btn);
        }
        if (flagX) {
            return 1;
        }
        if (flagO) {
            return 2;
        }
        return 0;
    }

    public void setWinnerVideo(Stage stage) throws MalformedURLException {

        Dialog<Void> winnerDialog = new Dialog<>();
        winnerDialog.setTitle("STATUS");

        Media media = new Media(getClass().getResource("Images/winnerVideo.mp4").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        mediaView.setFitWidth(500);
        mediaView.setFitHeight(300);

        VBox content = new VBox(mediaView);

        //main content VBox
        VBox mainContent = new VBox(content);
        mainContent.setPrefSize(500, 300);
        mainContent.setAlignment(Pos.CENTER);

        // hide the close button using CSS
        DialogPane dialogPane = winnerDialog.getDialogPane();
        dialogPane.getButtonTypes().add(ButtonType.CLOSE);
        Node closeButton = dialogPane.lookupButton(ButtonType.CLOSE);
        closeButton.managedProperty().bind(closeButton.visibleProperty());
        closeButton.setVisible(false);

        // stretch the video
        mediaView.fitWidthProperty().bind(winnerDialog.getDialogPane().widthProperty());
        mediaView.fitHeightProperty().bind(winnerDialog.getDialogPane().heightProperty());

        Label textOnVideo = new Label("Winner Winner Chicken Dinner");
        textOnVideo.setFont(new Font("Berlin Sans FB", 30.0));
        textOnVideo.setTextFill(javafx.scene.paint.Color.rgb(243, 16, 16));
        textOnVideo.setStyle("-fx-background-color: #FFFF99 ; -fx-padding: 2px;");

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1),textOnVideo );
        fadeIn.setFromValue(0.6);
        fadeIn.setToValue(1.0);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), textOnVideo );
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.4);

        SequentialTransition sequentialTransition = new SequentialTransition(fadeIn, fadeOut);
        sequentialTransition.setCycleCount(SequentialTransition.INDEFINITE);

        StackPane stackPane = new StackPane(mediaView, textOnVideo );
        StackPane.setAlignment(textOnVideo , Pos.CENTER);
        winnerDialog.getDialogPane().setContent(stackPane);

        mediaPlayer.setOnEndOfMedia(() -> {
            sequentialTransition.stop();
            winnerDialog.setResult(null);
            winnerDialog.close();
        });

        winnerDialog.setOnShowing(e -> {
            mediaPlayer.play();
            sequentialTransition.play();
        });

        winnerDialog.setOnHidden(new EventHandler<DialogEvent>() {
            @Override
            public void handle(DialogEvent event) {
                mediaPlayer.stop();
            }
        });
        winnerDialog.showAndWait();
    }

    public void setLoserVideo(Stage stage) {

        Dialog<Void> loserDialog = new Dialog<>();
        loserDialog.setTitle("STATUS");
        Media media = new Media(getClass().getResource("Images/loserVieo.mp4").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        mediaView.setFitWidth(500);
        mediaView.setFitHeight(300);

        VBox content = new VBox(mediaView);

        //main content VBox
        VBox mainContent = new VBox(content);
        mainContent.setPrefSize(500, 300);
        mainContent.setAlignment(Pos.CENTER);

        //hide the close button using CSS
        DialogPane dialogPane = loserDialog.getDialogPane();
        dialogPane.getButtonTypes().add(ButtonType.CLOSE);
        Node closeButton = dialogPane.lookupButton(ButtonType.CLOSE);
        closeButton.managedProperty().bind(closeButton.visibleProperty());
        closeButton.setVisible(false);

        // stretch the video
        mediaView.fitWidthProperty().bind(loserDialog.getDialogPane().widthProperty());
        mediaView.fitHeightProperty().bind(loserDialog.getDialogPane().heightProperty());

        Label textOnVideo  = new Label("   ...Hard Luck...   ");
        textOnVideo .setFont(new Font("Berlin Sans FB", 30.0));
        textOnVideo .setTextFill(javafx.scene.paint.Color.rgb(243, 16, 16));
        textOnVideo .setStyle("-fx-background-color: #FFFF99 ; -fx-padding: 2px;");

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), textOnVideo);
        fadeIn.setFromValue(0.6);
        fadeIn.setToValue(1.0);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), textOnVideo);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.4);

        SequentialTransition sequentialTransition = new SequentialTransition(fadeIn, fadeOut);
        sequentialTransition.setCycleCount(SequentialTransition.INDEFINITE);

        StackPane stackPane = new StackPane(mediaView, textOnVideo);
        StackPane.setAlignment(textOnVideo, Pos.CENTER);
        loserDialog.getDialogPane().setContent(stackPane);

        mediaPlayer.setOnEndOfMedia(() -> {
            sequentialTransition.stop();
           loserDialog.setResult(null);
            loserDialog.close();
        });

        loserDialog.setOnShowing(e -> {
            mediaPlayer.play();
            sequentialTransition.play();
        });

        loserDialog.setOnHidden(new EventHandler<DialogEvent>() {
            @Override
            public void handle(DialogEvent event) {
                mediaPlayer.stop();
            }
        });
       loserDialog.showAndWait();
    }

    public void setDrawVideo(Stage stage) {

        Dialog<Void> drawDialog = new Dialog<>();
        drawDialog.setTitle("STATUS");
 
        Media media = new Media(getClass().getResource("Images/drawVideo.mp4").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        mediaView.setFitWidth(500);
        mediaView.setFitHeight(300);

        VBox content = new VBox(mediaView);

        //main content VBox
        VBox mainContent = new VBox(content);
        mainContent.setPrefSize(500, 300);
        mainContent.setAlignment(Pos.CENTER);

        //hide close button using CSS
        DialogPane dialogPane = drawDialog.getDialogPane();
        dialogPane.getButtonTypes().add(ButtonType.CLOSE);
        Node closeButton = dialogPane.lookupButton(ButtonType.CLOSE);
        closeButton.managedProperty().bind(closeButton.visibleProperty());
        closeButton.setVisible(false);

        // stretch the video 
        mediaView.fitWidthProperty().bind(drawDialog.getDialogPane().widthProperty());
        mediaView.fitHeightProperty().bind(drawDialog.getDialogPane().heightProperty());

        Label textOnVideo  = new Label("     ... Draw ...     ");
        textOnVideo.setFont(new Font("Berlin Sans FB", 30.0));
        textOnVideo.setTextFill(javafx.scene.paint.Color.rgb(243, 16, 16));
        textOnVideo.setStyle("-fx-background-color: #FFFF99 ; -fx-padding: 2px;");

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(1), textOnVideo);
        fadeIn.setFromValue(0.6);
        fadeIn.setToValue(1.0);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(1), textOnVideo);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.4);

        SequentialTransition sequentialTransition = new SequentialTransition(fadeIn, fadeOut);
        sequentialTransition.setCycleCount(SequentialTransition.INDEFINITE);

        StackPane stackPane = new StackPane(mediaView, textOnVideo);
        StackPane.setAlignment(textOnVideo, Pos.CENTER);
        drawDialog.getDialogPane().setContent(stackPane);

        mediaPlayer.setOnEndOfMedia(() -> {
            sequentialTransition.stop();
            drawDialog.setResult(null);
            drawDialog.close();
        });

        drawDialog.setOnShowing(e -> {
            mediaPlayer.play();
            sequentialTransition.play();
        });

        drawDialog.setOnHidden(new EventHandler<DialogEvent>() {
            @Override
            public void handle(DialogEvent event) {
                mediaPlayer.stop();
            }
        });
       drawDialog.showAndWait();

    }

    public static void checkExit(Stage stage) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Alarm");
        alert.setHeaderText("Are you sure you want to quit the game?");
        ButtonType buttonYes = new ButtonType("Yes");
        ButtonType buttonCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonYes, buttonCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonYes) {
            ComputerMode.personScore = 0;
            ComputerMode.computerScore = 0;
            LocalMode.scorePlayer1 = 0;
            LocalMode.scorePlayer2 = 0;
            stage.setScene(new Scene(new ChooseMode(stage)));
        }
    }

    static public void highlightWinPlace(int[] indices, Button[] btn) {
        for (int index : indices) {
            btn[index].setStyle("-fx-background-color: #00FF00;");
        }
        for (int i = 0; i < 9; i++) {
            if ((i != indices[0]) && (i != indices[1]) && (i != indices[2])) {
                btn[i].setDisable(true);
            }
        }
    }

}
