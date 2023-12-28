package tictactoeserver;

import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class FXMLServer extends AnchorPane {

    protected final Button controlBtn;
    protected final PieChart pieChart;
    protected final ImageView imageView;
    protected final Label onlineTxt;
    protected final Label offlineTxt;

    public FXMLServer() {

        controlBtn = new Button();
        pieChart = new PieChart();
        imageView = new ImageView();
        onlineTxt = new Label();
        offlineTxt = new Label();

        setId("AnchorPane");
        setPrefHeight(500.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color: #42C4F7;");

        controlBtn.setLayoutX(37.0);
        controlBtn.setLayoutY(194.0);
        controlBtn.setMnemonicParsing(false);
        controlBtn.setPrefHeight(80.0);
        controlBtn.setPrefWidth(236.0);
        controlBtn.setStyle("-fx-background-color: #00886D; -fx-background-radius: 50;");
        controlBtn.setText("START");
        controlBtn.setTextFill(javafx.scene.paint.Color.valueOf("#f8f8f8"));
        controlBtn.setFont(new Font("Berlin Sans FB", 44.0));

        pieChart.setLayoutX(334.0);
        pieChart.setLayoutY(42.0);
        pieChart.setPrefHeight(417.0);
        pieChart.setPrefWidth(326.0);

        imageView.setFitHeight(120.0);
        imageView.setFitWidth(236.0);
        imageView.setLayoutX(37.0);
        imageView.setLayoutY(42.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Images/tictactoeServer.png").toExternalForm()));

        onlineTxt.setLayoutX(52.0);
        onlineTxt.setLayoutY(342.0);
        onlineTxt.setText("Online Players:  ");
        onlineTxt.setTextFill(javafx.scene.paint.Color.valueOf("#00886d"));
        onlineTxt.setFont(new Font("Berlin Sans FB", 28.0));

        offlineTxt.setLayoutX(51.0);
        offlineTxt.setLayoutY(392.0);
        offlineTxt.setText("Offline Players:  ");
        offlineTxt.setTextFill(javafx.scene.paint.Color.valueOf("#ce091e"));
        offlineTxt.setFont(new Font("Berlin Sans FB", 28.0));

        getChildren().add(controlBtn);
        getChildren().add(pieChart);
        getChildren().add(imageView);
        getChildren().add(onlineTxt);
        getChildren().add(offlineTxt);

    }
}
