/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class TicTacToeServer extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        FXMLServer s = new FXMLServer(stage);
        //Server s = new Server();
        Scene scene = new Scene(s);
        
        stage.setScene(scene);
        
        stage.show();
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        //Server s = new Server();
         
    }
    
}
