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


/**
 *
 * @author user
 */
public class TicTacToeClient extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
      Local_mode root = new Local_mode(stage);
      ProfileHome root2 = new ProfileHome(stage);
      
      
      Stage stage2 = new Stage();
      stage2.setScene(new Scene(root2));
      

        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        stage.show();
        stage2.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
