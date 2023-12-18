package tictactoeclient;

import java.util.ArrayList;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChoosePlayer extends Pane {

    protected final Text text;
    protected final Text text0;
    protected final Rectangle rectangle;
    protected final Text text1;
    protected final Text text2;
    protected final Button btnBack;
    protected final Button profilrbtn;
    protected final ImageView profile;
    protected final Text text3;
    protected final VBox vBox;

    protected final VBox vBox0;

    protected final VBox vBox1;

    protected final Button logoutBut;
    
    ArrayList<Button> buttons ;
    ArrayList<Text> userNames ;
    ArrayList<Text> scores ;

    public ChoosePlayer(Stage stage) {

        text = new Text();
        text0 = new Text();
        rectangle = new Rectangle();
        text1 = new Text();
        text2 = new Text();
        btnBack = new Button();
        profilrbtn = new Button();
        profile = new ImageView();
        text3 = new Text();
        vBox = new VBox();

        vBox0 = new VBox();

        vBox1 = new VBox();

        logoutBut = new Button();
        buttons = new ArrayList<Button>();
        userNames = new ArrayList<Text>();
        scores = new ArrayList<Text>();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(700.0);
        setStyle("-fx-background-color: #42C4F7;");

        text.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text.setStrokeWidth(0.0);
        text.setText("Text");

        text0.setFill(javafx.scene.paint.Color.WHITE);
        text0.setLayoutX(259.0);
        text0.setLayoutY(49.0);
        text0.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text0.setStrokeWidth(0.0);
        text0.setText("Avaliable Players");
        text0.setWrappingWidth(182.11328125);
        text0.setFont(new Font("Berlin Sans FB", 24.0));

        rectangle.setArcHeight(55.0);
        rectangle.setArcWidth(55.0);
        rectangle.setFill(javafx.scene.paint.Color.WHITE);
        rectangle.setHeight(394.0);
        rectangle.setLayoutX(18.0);
        rectangle.setLayoutY(78.0);
        rectangle.setStroke(javafx.scene.paint.Color.WHITE);
        rectangle.setStrokeType(javafx.scene.shape.StrokeType.INSIDE);
        rectangle.setWidth(664.0);

        text1.setFill(javafx.scene.paint.Color.valueOf("#00000080"));
        text1.setLayoutX(73.0);
        text1.setLayoutY(129.0);
        text1.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text1.setStrokeWidth(0.0);
        text1.setText("name");
        text1.setFont(new Font("Berlin Sans FB", 20.0));

        text2.setFill(javafx.scene.paint.Color.valueOf("#00000080"));
        text2.setLayoutX(292.0);
        text2.setLayoutY(130.0);
        text2.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text2.setStrokeWidth(0.0);
        text2.setText("score");
        text2.setFont(new Font("Berlin Sans FB", 20.0));

        btnBack.setLayoutX(7.0);
        btnBack.setLayoutY(4.0);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(25.0);
        btnBack.setPrefWidth(22.0);
        btnBack.setStyle("-fx-background-color: #42C4F7;");

        profilrbtn.setLayoutX(604.0);
        profilrbtn.setLayoutY(5.0);
        profilrbtn.setMnemonicParsing(false);
        profilrbtn.setPrefHeight(49.0);
        profilrbtn.setPrefWidth(59.0);
        profilrbtn.setStyle("-fx-background-color: #42C4F7;");
        profilrbtn.setFont(new Font("Berlin Sans FB", 18.0));

        profile.setFitHeight(56.0);
        profile.setFitWidth(67.0);
        profile.setImage(new Image(getClass().getResource("Images/icons8-username-48.png").toExternalForm()));
        profilrbtn.setGraphic(profile);

        text3.setFill(javafx.scene.paint.Color.valueOf("#00000080"));
        text3.setLayoutX(497.0);
        text3.setLayoutY(129.0);
        text3.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
        text3.setStrokeWidth(0.0);
        text3.setText("Invitation");
        text3.setFont(new Font("Berlin Sans FB", 20.0));

        vBox.setLayoutX(73.0);
        vBox.setLayoutY(150.0);
        vBox.setPrefHeight(300.0);
        vBox.setPrefWidth(154.0);



        vBox0.setLayoutX(292.0);
        vBox0.setLayoutY(150.0);
        vBox0.setPrefHeight(284.0);
        vBox0.setPrefWidth(141.0);



        vBox1.setLayoutX(490.0);
        vBox1.setLayoutY(150.0);
        vBox1.setPrefHeight(300.0);
        vBox1.setPrefWidth(141.0);


        logoutBut.setLayoutX(22.0);
        logoutBut.setLayoutY(26.0);
        logoutBut.setMnemonicParsing(false);
        logoutBut.setPrefHeight(26.0);
        logoutBut.setPrefWidth(80.0);
        logoutBut.setStyle("-fx-background-color: #F35162; -fx-border-radius: 15; -fx-background-radius: 15;");
        logoutBut.setText("Log Out");
        logoutBut.setTextFill(javafx.scene.paint.Color.WHITE);
        logoutBut.setFont(new Font("Berlin Sans FB", 14.0));

        getChildren().add(text);
        getChildren().add(text0);
        getChildren().add(rectangle);
        getChildren().add(text1);
        getChildren().add(text2);
        getChildren().add(btnBack);
        getChildren().add(profilrbtn);
        getChildren().add(text3);
        getChildren().add(vBox);
        getChildren().add(vBox0);
        getChildren().add(vBox1);
        getChildren().add(logoutBut);
        
        
        for(int i=0 ;i<3;i++)
        {
            Text text_name = new Text();
            text_name.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            text_name.setStrokeWidth(0.0);
            text_name.setText("Ahmed");
            text_name.setFont(new Font("Berlin Sans FB", 16.0));
            userNames.add(text_name);

            Text text_score = new Text();
            text_score.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            text_score.setStrokeWidth(0.0);
            text_score.setText("400");
            text_score.setFont(new Font("Berlin Sans FB", 16.0));
            scores.add(text_score);
            
            Button invite = new Button();
            invite.setMnemonicParsing(false);
            invite.setPrefHeight(31.0);
            invite.setPrefWidth(98.0);
            invite.setStyle("-fx-background-color: green; -fx-border-radius: 15; -fx-background-radius: 15;");
            invite.setText("Invite");
            invite.setTextFill(javafx.scene.paint.Color.WHITE);
            invite.setFont(new Font("Berlin Sans FB", 16.0));
            buttons.add(invite);
            
            vBox.getChildren().add(text_name);
            vBox.getChildren().add(new Text("\n \n"));
                        //vBox.getChildren().add(new Text("\n"));

            vBox0.getChildren().add(text_score);
            vBox0.getChildren().add(new Text("\n\n"));
            
            vBox1.getChildren().add(invite);
            vBox1.getChildren().add(new Text("\n"));
            
            invite.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event){
                     /*Dialog<String> dialog = new Dialog<String>();
                     dialog.setTitle("Dialog");
                     dialog.setContentText("This is a sample dialog");
                     dialog.show();
                    dialog.close();
                    */
                    invite.setDisable(true);
                }
            });
              
        }
        
        logoutBut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(new Scene(new SignIn(stage)));
            }
        });
        
        profilrbtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.setScene(new Scene(new ProfileHome(stage)));
            }
        });
        



    }
}
