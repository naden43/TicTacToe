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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.derby.jdbc.ClientDriver;
//import org.apache.derby.jdbc.ClientDriver;

/**
 *
 * @author user
 */
public class TicTacToeClient extends Application {

    @Override

    public void start(Stage stage) throws Exception {
 
       DriverManager.registerDriver(new ClientDriver());
       Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/GameLogic", "root", "root");
        StartScreen root = new StartScreen(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("TicTacToe");
        stage.setResizable(false);
        stage.show();
        
        

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
