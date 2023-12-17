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
    
    static public int checkWin(char [] board , Button [] btn) // 1-3(rows) 4-6(columns) 7-8(diagonal)   1-x 2-0 3-noOne
    {
        boolean flagX = false ;
        boolean flagO = false ;
        //horizontal
        for(int i=0 ;i<9 ;i+=3)
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
                flagX = true;
                int []index = {i , i+1 , i+2};
                highlightWinPlace(index, btn);
                break;
            }
            
        }
        //vertical
        for(int i=0 ;i<9 ;i+=3)
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
                flagX = true;
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
    
    /*static public boolean haveSameValue(char place1 , char place2 , char place3 )
    {
        
        return true;
    }*/
    
    static public void highlightWinPlace(int []indices , Button []btn)
    {
           
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
    
    /*public static void setDrawDialog(Stage stage)
    {
        
    }*/
    
}
