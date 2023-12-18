/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
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
public class TicTacToeClient extends Application {

    @Override
<<<<<<< HEAD
    public void start(Stage stage) throws Exception {
      Local_mode root = new Local_mode(stage);
      ProfileHome root2 = new ProfileHome(stage);
      
      
      Stage stage2 = new Stage();
      stage2.setScene(new Scene(root2));
      

        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        stage.show();
        stage2.show();
=======
    public void start(Stage stage) throws Exception { 
        
        new GameLogic().setDrawVideo(stage);
//    LocalMode root = new LocalMode(stage);       
//    Scene scene = new Scene(root);
//    stage.setScene(scene);
//   stage.show();
>>>>>>> 0eae1ff85237b1adb72fd7453b91c60fb8f3e180
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
