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
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class GameLogic {

    static public boolean checkWin(char[] board) // 1-3(rows) 4-6(columns) 7-8(diagonal)
    {

        return true;
    }

    /*static public boolean haveSameValue(char place1 , char place2 , char place3 )
    {
        
        return true;
    }*/
    static public void highlightWinPlace(int place1, int place2, int place3) {

    }

    static public void setWinnerVideo(Stage stage) {

    }

    public static void setLoserVideo(Stage stage) {

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

    public static void setDrawDialog(Stage stage) {

    }

}
