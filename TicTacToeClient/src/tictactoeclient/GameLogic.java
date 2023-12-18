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
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class GameLogic {


    static public int checkWin(char [] board , Button [] btn) // 1-3(rows) 4-6(columns) 7-8(diagonal)   1-x 2-0 3-noOne
    {
        boolean flagX = false ;
        boolean flagO = false ;
        //horizontal
        for(int i=0 ;i<3 ;i+=3)
        {
            if(board[i]=='X' && board[i+1]=='X' && board[i+2]=='X')
            {
                flagX = true;
                int []index = {i , i+1 , i+2};
                highlightWinPlace(index, btn);
                break;
            }
            if(board[i]=='O' && board[i+1]=='O' && board[i+2]=='O')
            {
                flagO= true;
                int []index = {i , i+1 , i+2};
                highlightWinPlace(index, btn);
                break;
            }
            
        }
        //vertical
        for(int i=0 ;i<3 ;i+=1)
        {
            if(board[i]=='X' && board[i+3]=='X' && board[i+6]=='X')
            {
                flagX = true;
                int []index = {i , i+3 , i+6};
                highlightWinPlace(index, btn);
                break;
            }
            if(board[i]=='O' && board[i+3]=='O' && board[i+6]=='O')
            {
                flagO = true;
                int []index = {i , i+3 , i+6};
                highlightWinPlace(index, btn);
                break;
            }
            
        }       
        //diagonal

        if(board[0]=='X' && board[4]=='X' && board[8]=='X')
        {
            flagX = true;
            int []index = {0 , 4 , 8};
            highlightWinPlace(index, btn);
            
        }
        else if(board[0]=='O' && board[4]=='O' && board[8]=='O')
        {
            flagO = true;
            int []index = {0 , 4 , 8};
            highlightWinPlace(index, btn);
            
        }
        else if(board[2]=='O' && board[4]=='O' && board[6]=='O')
        {
            flagO = true;
            int []index = {2 , 4 , 6};
            highlightWinPlace(index, btn);
            
        }
        else if(board[2]=='X' && board[4]=='X' && board[6]=='X')
        {
            flagX = true;
            int []index = {2 , 4 , 6};
            highlightWinPlace(index, btn);
            
        }
        
        
        if(flagX)
        {
            return 1 ;
        }
        if(flagO)
        {
            return 2;
        }
        
        return 0 ;
                      
        
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


    public static void checkExit(Stage stage) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit Alarm");
        alert.setHeaderText("Are you sure you want to quit the game?");
        ButtonType buttonYes = new ButtonType("Yes");
        ButtonType buttonCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonYes, buttonCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == buttonYes) {
            stage.setScene(new Scene(new SignIn(stage)));
        }
    }
    static public void highlightWinPlace(int[] indices, Button[] btn) {
        for (int index : indices) {
            btn[index].setStyle("-fx-background-color: #00FF00;");
        }
    }
    
}
