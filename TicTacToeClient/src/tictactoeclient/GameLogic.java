/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeclient;

import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class GameLogic {
    
    static public boolean checkWin(char [] board) // 1-3(rows) 4-6(columns) 7-8(diagonal)
    {
                       
        return true;
    }
    
    /*static public boolean haveSameValue(char place1 , char place2 , char place3 )
    {
        
        return true;
    }*/
    
    static public void highlightWinPlace(int[] indices, Button[] btn) {
        for (int index : indices) {
            btn[index].setStyle("-fx-background-color: #00FF00;");
        }
    }
    
    static public void setWinnerVideo(Stage stage)
    {
        
    }

    public static void setLoserVideo(Stage stage)
    {
        
    }
    
    public static void checkExit(Stage stage)
    {
        
    }
    
    public static void setDrawDialog(Stage stage)
    {
        
    }
    
}
