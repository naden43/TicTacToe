package tictactoeclient;

import playerhelper.PlayerHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import playerhelper.PlayerHandler;



public class TicTacToeClient extends Application {

    static Stage stage ;
    public static PlayerHandler playerHandler = new PlayerHandler();
    
    @Override
    public void start(Stage stage) throws Exception {
        StartScreen root = new StartScreen(stage);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("TicTacToe");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}
