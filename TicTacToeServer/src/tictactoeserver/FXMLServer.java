package tictactoeserver;

import database.DatabaseSupplier;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class FXMLServer extends AnchorPane {

    public static boolean flag;
    //public static boolean flag2;
    public static Server server;
    protected final Button controlBtn;
    protected final PieChart pieChart;
    protected final ImageView imageView;
    protected final Label onlineTxt;
    protected final Label offlineTxt;

    protected ObservableList<PieChart.Data> pieChartList;
    protected static int offlineNumber;
    protected static int onlineNumber;

    private Thread thread;
    private final DatabaseSupplier databaseSupplier;

    public FXMLServer(Stage stage) {

        controlBtn = new Button();
        pieChart = new PieChart();
        imageView = new ImageView();
        onlineTxt = new Label();
        offlineTxt = new Label();
        databaseSupplier = new DatabaseSupplier();
        flag = false;

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

        pieChart.setClockwise(true);
        pieChart.setLabelLineLength(30);
        pieChart.setStartAngle(90);
        pieChart.setLabelsVisible(true);
        pieChart.setLegendVisible(true);
        pieChart.setLegendSide(Side.BOTTOM);

        imageView.setFitHeight(120.0);
        imageView.setFitWidth(236.0);
        imageView.setLayoutX(37.0);
        imageView.setLayoutY(42.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("Images/tictactoeServer.png").toExternalForm()));

        onlineTxt.setLayoutX(52.0);
        onlineTxt.setLayoutY(342.0);
        onlineTxt.setTextFill(javafx.scene.paint.Color.valueOf("#2F43FB"));
        onlineTxt.setFont(new Font("Berlin Sans FB", 28.0));

        offlineTxt.setLayoutX(51.0);
        offlineTxt.setLayoutY(392.0);

        offlineTxt.setTextFill(javafx.scene.paint.Color.valueOf("#F35162"));
        offlineTxt.setFont(new Font("Berlin Sans FB", 28.0));

        getChildren().add(controlBtn);
        getChildren().add(pieChart);
        getChildren().add(imageView);
        getChildren().add(onlineTxt);
        getChildren().add(offlineTxt);
        pieChart.setVisible(false);

        controlBtn.setOnAction(e -> {
            if (!flag) {
                onlineNumber = databaseSupplier.selectOnline();
                offlineNumber = databaseSupplier.selectOffline();
                pieChartList = initPieChartData(onlineNumber, offlineNumber);
                pieChart.setData(pieChartList);
                pieChart.setVisible(true);

                controlBtn.setText("STOP");
                controlBtn.setStyle("-fx-background-color: #CE091E; -fx-background-radius: 50;");
                onlineTxt.setText("Online Players:  " + onlineNumber);
                offlineTxt.setText("Offline Players:  " + offlineNumber);
                server = new Server();
                flag = true;
                updatePieChart();
            } else {

                controlBtn.setText("START");
                controlBtn.setStyle("-fx-background-color: #00886D; -fx-background-radius: 50;");
                onlineTxt.setText("");
                offlineTxt.setText("");
                pieChart.setVisible(false);
                flag = false;
                server.close();
                thread.stop();
            }

        });
    }

    private ObservableList<PieChart.Data> initPieChartData(int onlineNumber, int offlineNumber) {
        ObservableList<PieChart.Data> pieChartData;
        pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Online", onlineNumber),
                new PieChart.Data("Offline", offlineNumber)
        );
        return pieChartData;
    }

    public void updatePieChart() {
        if (flag == true) {
            thread = new Thread() {
                public void run() {
                    while (server.isAlive()) {
                        try {
                            Thread.sleep(10000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(FXMLServer.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        Platform.runLater(() -> {
                            onlineNumber = databaseSupplier.selectOnline();
                            offlineNumber = databaseSupplier.selectOffline();
                            pieChartList = initPieChartData(onlineNumber, offlineNumber);
                            pieChart.setData(pieChartList);
                            onlineTxt.setText("Online Players:  " + onlineNumber);
                            offlineTxt.setText("Offline Players:  " + offlineNumber);
                        });
                    }
                }
            };
            thread.start();   // احذر منطقة خطر
        }
    }
}
