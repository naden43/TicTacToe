package tictactoeclient;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import playerhelper.PlayerDetails;

public class RecordList extends AnchorPane {

    protected final Label label;
    protected final ImageView imageView;
    protected final VBox vBox;
    protected final ScrollPane scrollview;
    protected final AnchorPane anchorPane;
    protected final ListView<String> listView; 
    protected final ImageView backbtn;

    private ObservableList<String> records = FXCollections.observableArrayList();

    public RecordList(Stage stage , PlayerDetails playerDetails) {

        label = new Label();
        imageView = new ImageView();
        vBox = new VBox();
        scrollview = new ScrollPane();
        anchorPane = new AnchorPane();
        listView = new ListView<>(records);
        backbtn = new ImageView();

        setId("AnchorPane");
        setPrefHeight(500.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color: #42C4F7;");

        label.setPrefHeight(65.0);
        label.setPrefWidth(701.0);
        label.setStyle("-fx-background-color: #42C4F7;");
        label.setText("                   Records");
        label.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        label.setTextFill(javafx.scene.paint.Color.WHITE);
        label.setFont(new Font("Berlin Sans FB", 50.0));

        imageView.setFitHeight(51.0);
        imageView.setFitWidth(58.0);
        imageView.setLayoutX(409.0);
        imageView.setLayoutY(9.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Images/video.png").toExternalForm()));

        vBox.setLayoutX(1.0);
        vBox.setLayoutY(71.0);
        vBox.setPrefHeight(429.0);
        vBox.setPrefWidth(700.0);
        vBox.setStyle("-fx-background-color: #42C4F7;");

        scrollview.setPrefHeight(434.0);
        scrollview.setPrefWidth(700.0);

        anchorPane.setMinHeight(0.0);
        anchorPane.setMinWidth(0.0);
        anchorPane.setPrefHeight(426.0);
        anchorPane.setPrefWidth(699.0);

        listView.setPrefHeight(436.0);
        listView.setPrefWidth(700.0);
        scrollview.setContent(anchorPane);

        backbtn.setFitHeight(51.0);
        backbtn.setFitWidth(72.0);
        backbtn.setLayoutX(14.0);
        backbtn.setLayoutY(9.0);
        backbtn.setPickOnBounds(true);
        backbtn.setPreserveRatio(true);
        backbtn.setImage(new Image(getClass().getResource("Images/back.png").toExternalForm()));
        backbtn.setOnMouseClicked((e)->{
          
             stage.setScene(new Scene(new ProfileHome(stage ,playerDetails )));
        });
        loadRecordedGames();
        

        getChildren().add(label);
        getChildren().add(imageView);
        anchorPane.getChildren().add(listView);
        vBox.getChildren().add(scrollview);
        getChildren().add(vBox);
        getChildren().add(backbtn);
    }

    public void loadRecordedGames() {
        String directoryPath = "E:\\material ITI\\Courses Fundementals\\Java\\Project\\TicTacToe\\TicTacToeClient";
        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] gameFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));
            if (gameFiles != null) {
                List<String> gameFileNames = Arrays.stream(gameFiles).map(File::getName).collect(Collectors.toList());
                records.setAll(gameFileNames);
            }
        }

        listView.setOnMouseClicked(event -> {
            String selectedRecord = listView.getSelectionModel().getSelectedItem();
            if (selectedRecord != null) {
                // Load the selected recorded game
                loadSelectedRecord(selectedRecord);
            }
        });
    }

    private void loadSelectedRecord(String selectedRecord) {
       
    }
}
