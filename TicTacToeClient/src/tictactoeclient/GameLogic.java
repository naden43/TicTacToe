/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;


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

    /*static public boolean haveSameValue(char place1 , char place2 , char place3 )
    {
        
        return true;
    }*/

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
