package tictactoeclient;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import playerhelper.PlayerDetails;

public class ChoosePlayer extends ScrollPane {

    protected final AnchorPane anchorPane;
    protected final Text text;
    protected final Text text0;
    protected final Button btnBack;
    protected final Button profilrbtn;
    protected final Text text3;
    static protected final VBox vBox;
    static protected final VBox vBox0;
    static protected final VBox vBox1;
    protected final Button logoutBut;
    protected final Rectangle rectangle;
    protected final Text text1;
    protected final Text text2;

    static ArrayList<Button> buttons;
    static ArrayList<PlayerDetails> players;

    static 
    {
        vBox = new VBox();
        vBox0 = new VBox();
        vBox1 = new VBox();
    }
    public ChoosePlayer(Stage stage , ArrayList<PlayerDetails> players){
        anchorPane = new AnchorPane();
        text = new Text();
        text0 = new Text();
        btnBack = new Button();
        profilrbtn = new Button();
        text3 = new Text();
        
        logoutBut = new Button();
        buttons = new ArrayList<>();
        rectangle = new Rectangle();
        text1 = new Text();
        text2 = new Text();

        this.players = players;
        setContent(anchorPane);
        anchorPane.setStyle("-fx-background-color: #42C4F7;");
        anchorPane.setPrefHeight(500.0);
        anchorPane.setPrefWidth(700.0);
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
        rectangle.setArcHeight(55.0);
        rectangle.setArcWidth(55.0);
        rectangle.setFill(javafx.scene.paint.Color.WHITE);
        rectangle.setHeight(300);
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
        vBox.setPrefWidth(141.0);

        vBox0.setLayoutX(292.0);
        vBox0.setLayoutY(150.0);
        vBox0.setPrefHeight(300.0);
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

        anchorPane.getChildren().add(rectangle);
        anchorPane.getChildren().add(text);
        anchorPane.getChildren().add(text0);
        anchorPane.getChildren().add(text1);
        anchorPane.getChildren().add(text2);
        anchorPane.getChildren().add(btnBack);
        anchorPane.getChildren().add(profilrbtn);
        anchorPane.getChildren().add(text3);
        anchorPane.getChildren().add(vBox);
        anchorPane.getChildren().add(vBox0);
        anchorPane.getChildren().add(vBox1);
        anchorPane.getChildren().add(logoutBut);

        for (int i = 0; i < players.size(); i++) {
            /*if(i==5)
            {
                rectangle.setHeight(rectangle.getHeight()+((6-i)*75));
            }*/
            Text text_name = new Text();
            text_name.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            text_name.setStrokeWidth(0.0);
            text_name.setText(players.get(i).getUserName());
            text_name.setFont(new Font("Berlin Sans FB", 16.0));
            

            Text text_score = new Text();
            text_score.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            text_score.setStrokeWidth(0.0);
            text_score.setText(players.get(i).getScore()+"");
            text_score.setFont(new Font("Berlin Sans FB", 16.0));
            

            Button invite = new Button();
            invite.setMnemonicParsing(false);
            invite.setPrefHeight(30.0);
            invite.setPrefWidth(98.0);
            invite.setStyle("-fx-background-color: green; -fx-border-radius: 15; -fx-background-radius: 15;");
            invite.setText("Invite");
            invite.setTextFill(javafx.scene.paint.Color.WHITE);
            invite.setFont(new Font("Berlin Sans FB", 16.0));
            buttons.add(invite);

            vBox.getChildren().addAll(text_name, new Text("\n \n") );
            vBox0.getChildren().addAll(text_score, new Text("\n \n"));
            vBox1.getChildren().addAll(invite, new Text("\n"));

            invite.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
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
    
    static public void listPlayers(String user , PlayerDetails player)
    {
         
            System.out.println(player.getUserName());
            /*if(user.equals(player.getUserName()))
            {
                return;
            }
            else
            {*/
            players.add(player);
            Text text_name = new Text();
            text_name.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            text_name.setStrokeWidth(0.0);
            text_name.setText(player.getUserName());
            text_name.setFont(new Font("Berlin Sans FB", 16.0));
            

            Text text_score = new Text();
            text_score.setStrokeType(javafx.scene.shape.StrokeType.OUTSIDE);
            text_score.setStrokeWidth(0.0);
            text_score.setText(player.getScore()+"");
            text_score.setFont(new Font("Berlin Sans FB", 16.0));
            

            Button invite = new Button();
            invite.setMnemonicParsing(false);
            invite.setPrefHeight(30.0);
            invite.setPrefWidth(98.0);
            invite.setStyle("-fx-background-color: green; -fx-border-radius: 15; -fx-background-radius: 15;");
            invite.setText("Invite");
            invite.setTextFill(javafx.scene.paint.Color.WHITE);
            invite.setFont(new Font("Berlin Sans FB", 16.0));
            buttons.add(invite);

            vBox.getChildren().addAll(text_name, new Text("\n \n") );
            vBox0.getChildren().addAll(text_score, new Text("\n \n"));
            vBox1.getChildren().addAll(invite, new Text("\n"));

            invite.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    invite.setDisable(true);
                    
                }
            });
        //}
    }
    }

