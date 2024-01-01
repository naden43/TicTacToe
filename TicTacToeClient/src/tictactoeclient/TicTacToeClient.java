/*
 
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
*/
package tictactoeclient;

import java.sql.Connection;
import java.sql.DriverManager;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.apache.derby.jdbc.ClientDriver;
import playerhelper.PlayerDetails;
import playerhelper.PlayerHandler;

public class TicTacToeClient extends Application {

    public  static PlayerHandler playerHandler;

    @Override

    public void start(Stage stage) throws Exception {

        Parent root = new StartScreen(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("TicTacToe");
        stage.setResizable(false);
        stage.show();
        playerHandler = new PlayerHandler(stage);

    }


  public static void main(String[] args) {
      launch(args);}


}
