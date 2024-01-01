package tictactoeclient;

import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PlayerVideo extends Pane {

    public static String video;
    protected final Text headerTxt;
    protected final MediaView playerMediaView;

    public PlayerVideo() {

        headerTxt = new Text();
        playerMediaView = new MediaView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(356.0);
        setPrefWidth(381.0);
        setStyle("-fx-background-color: #42C4F7;");

        headerTxt.setFill(javafx.scene.paint.Color.valueOf("#f35162"));
        headerTxt.setLayoutX(113.0);
        headerTxt.setLayoutY(55.0);
        headerTxt.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        headerTxt.setStrokeWidth(0.0);
        headerTxt.setText("Winner Winner");
        headerTxt.setFont(new Font("Berlin Sans FB", 25.0));

        playerMediaView.setFitHeight(250.0);
        playerMediaView.setFitWidth(250.0);
        playerMediaView.setLayoutX(65.0);
        playerMediaView.setLayoutY(61.0);

        Media media = new Media(getClass().getResource(video).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        playerMediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.setAutoPlay(true);
        
        getChildren().add(headerTxt);
        getChildren().add(playerMediaView);

    }
}
