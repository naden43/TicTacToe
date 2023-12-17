/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

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
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class GameLogic {

    static public int checkWin(char[] board, Button [] btn) // 1-3(rows) 4-6(columns) 7-8(diagonal)
    {

        return 0;
    }

    /*static public boolean haveSameValue(char place1 , char place2 , char place3 )
    {
        
        return true;
    }*/
    static public void highlightWinPlace(int [] indices, Button [] btn ) {

    }

    public void setWinnerVideo(Stage stage) throws MalformedURLException {
        
        Dialog<Void> alert = new Dialog<>();
        alert.setTitle("STATUS");
        alert.setHeaderText("");
        Media media = new Media(getClass().getResource("Images/winnerVideo.mp4").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        
        Label label = new Label("Winner Winner Chicken Dinner");
        label.setFont(new Font("Berlin Sans FB", 24.0));
        label.setTextFill(javafx.scene.paint.Color.rgb(243,81, 98));
       
        mediaView.setFitWidth(600);
        mediaView.setFitHeight(400);
         mediaView.setPreserveRatio(false);
        
        VBox content = new VBox(10, label, mediaView);
        Stage window = new Stage();
        content.setPrefSize(600, 500);
        content.setAlignment(Pos.CENTER);
        
        alert.getDialogPane().setContent(content);
        ButtonType closeButton = new ButtonType("Close", ButtonData.CANCEL_CLOSE);
        alert.getDialogPane().getButtonTypes().add(closeButton);
        alert.setOnShowing(e -> mediaPlayer.play());
        alert.showAndWait();
        
    }

    public void setLoserVideo(Stage stage) {
        
         Dialog<Void> alert = new Dialog<>();
        alert.setTitle("STATUS");
        alert.setHeaderText("");
        Media media = new Media(getClass().getResource("Images/loserVideo.mp4").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        
        mediaView.setFitWidth(600);
        mediaView.setFitHeight(400);
        
        Label label = new Label("Hard Luck...");
        label.setFont(new Font("Berlin Sans FB", 24.0));
        label.setTextFill(javafx.scene.paint.Color.rgb(243,81, 98));
       
     
        VBox content = new VBox(10, label, mediaView);
        Stage window = new Stage();
        content.setPrefSize(600, 500);
        content.setAlignment(Pos.CENTER);
        
        alert.getDialogPane().setContent(content);
        ButtonType closeButton = new ButtonType("Close", ButtonData.CANCEL_CLOSE);
        alert.getDialogPane().getButtonTypes().add(closeButton);
        alert.setOnShowing(e -> mediaPlayer.play());
        alert.showAndWait();

    }

    public static void checkExit(Stage stage) {

    }

    public void setDrawVideo(Stage stage) {

        Dialog<Void> alert = new Dialog<>();
        alert.setTitle("STATUS");
        alert.setHeaderText("");
        Media media = new Media(getClass().getResource("Images/loserVideo.mp4").toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);
        
        mediaView.setFitWidth(600);
        mediaView.setFitHeight(400);
        
        Label label = new Label("Draw...");
        label.setFont(new Font("Berlin Sans FB", 24.0));
        label.setTextFill(javafx.scene.paint.Color.rgb(243,81, 98));
       
     
        VBox content = new VBox(10, label, mediaView);
        Stage window = new Stage();
        content.setPrefSize(600, 500);
        content.setAlignment(Pos.CENTER);
        
        alert.getDialogPane().setContent(content);
        ButtonType closeButton = new ButtonType("Close", ButtonData.CANCEL_CLOSE);
        alert.getDialogPane().getButtonTypes().add(closeButton);
        alert.setOnShowing(e -> mediaPlayer.play());
        alert.showAndWait();
        
    }

}
