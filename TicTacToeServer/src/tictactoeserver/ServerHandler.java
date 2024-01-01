package tictactoeserver;

import com.google.gson.Gson;
import database.DatabaseSupplier;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import database.PlayerDetails;
import java.sql.Array;
import java.util.ArrayList;

public class ServerHandler {

    DataInputStream ear;
    PrintStream mouth;
    static Vector<ServerHandler> playerList = new Vector<>();
    Gson gson = new Gson();
    DatabaseSupplier databaseSupplier = new DatabaseSupplier();
    Thread th;
    ArrayList requestData;
    ArrayList resultData;
    String UserName;
    String opponentUser;
    String playChar;
    Socket clientSocket;

    public ServerHandler(Socket s) {
        clientSocket = s;
        try {
            ear = new DataInputStream(s.getInputStream());
            mouth = new PrintStream(s.getOutputStream());
            playerList.add(this);
            th = new Thread() {
                public void run() {
                    while (true) {
                        try {
                            String json = ear.readLine();
                            ;

                            requestData = gson.fromJson(json, ArrayList.class);
                            double key = (double) requestData.get(0);
                            if (key == 1) {
                                registration((String) requestData.get(1));
                            } else if (key == 2) {
                                signinAuthentication((String) requestData.get(1));
                                notifyAllUpdate();
                            } else if (key == 3) {

                                sendRequestToPlay((String) requestData.get(1));

                            } else if (key == 4) {
                                double keyAccept = (double) requestData.get(1);
                                if (keyAccept == 1) {
                                    sendAcceptRequest((String) requestData.get(2));
                                    //wait(10);
                                    //notifyAllUpdate();
                                } else if (keyAccept == 0) {
                                    sendRejectRequest((String) requestData.get(2));
                                }
                            } else if (key == 6) {
                                sendPlayToAnotherPlayer((double) requestData.get(1));
                            } else if (key == 8) { // here you are avaliable 
                                exitGame((boolean) requestData.get(1));
                                notifyAllUpdate();
                            } else if (key == 9) {
                                updateScore((double) requestData.get(1));
                                notifyAllUpdate();
                            } else if (key == 10) {
                                sendPlayAgainReguest();
                            } else if (key == 11) {

                                double key2 = ((double) requestData.get(1));
                                if (key2 == 1) {
                                    sendPlayAgainAccept();
                                } else {
                                    sendPlayAgainReject();
                                    notifyAllUpdate();
                                }
                            } else if (key == 16) {
                                logout((String) requestData.get(1));
                            } else if (key == 15) {
                                changePass((String) requestData.get(1));
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
                            break;
                        }

                    }
                }

            };
            th.start();
        } catch (IOException ex) {
            Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void sendPlayAgainReguest() {
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).UserName.equals(opponentUser)) {
                ArrayList msg = new ArrayList();
                msg.add(10);
                msg.add(opponentUser);
                playerList.get(i).mouth.println(gson.toJson(msg));
                break;
            }
        }
    }

    public void registration(String str) {
        int registrationResult = databaseSupplier.registerPlayer(str);

        // send registeration result back to Player handler
        requestData.clear();
        requestData.add(1);
        requestData.add(registrationResult);
        mouth.println(gson.toJson(requestData));
    }

    public void signinAuthentication(String str) {
        boolean status = databaseSupplier.getPlayerStatus(str);
        PlayerDetails playerDetails = databaseSupplier.login(str);
        ArrayList<PlayerDetails> players = null;

        requestData.clear();
        requestData.add(2);
        requestData.add(gson.toJson(playerDetails));
        requestData.add(status);
        if (playerDetails != null) {
            UserName = playerDetails.getUserName();
            players = databaseSupplier.getOnlineUsers(UserName);
        }
        requestData.add(gson.toJson(players));
        mouth.println(gson.toJson(requestData));

    }


    /*public PlayerDetails login(String str) {
        int registrationResult = databaseSupplier.loginPlayer(str);
        resultData = new ArrayList();
        resultData.add(2);
        PlayerDetails playerDetails = gson.fromJson(str, PlayerDetails.class);
        UserName = playerDetails.getUserName();
        resultData.add(registrationResult);
        ArrayList<PlayerDetails> players = databaseSupplier.getOnlineUsers(UserName);
        PlayerDetails player = databaseSupplier.getPlayer(UserName);    
        resultData.add(gson.toJson(players));
        mouth.println(gson.toJson(resultData));
        return player;
    }*/
    synchronized public void notifyAllUpdate() {
        for (int i = 0; i < playerList.size(); i++) {

            if (playerList.get(i).UserName != null) {
                ArrayList<PlayerDetails> players = databaseSupplier.getOnlineUsers(playerList.get(i).UserName);

                ArrayList notify = new ArrayList();
                notify.add(5);
                notify.add(playerList.get(i).UserName);
                notify.add(gson.toJson(players));
                playerList.get(i).mouth.println(gson.toJson(notify));
            }
        }
    }

    public void sendRequestToPlay(String userName) {
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).UserName.equals(userName)) {
                ArrayList msg = new ArrayList();
                msg.add(3);
                msg.add(UserName);
                playerList.get(i).mouth.println(gson.toJson(msg));
                break;
            }
        }
    }

    public void sendAcceptRequest(String senderName) {
        databaseSupplier.updateIsPlay(senderName, UserName);
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).UserName.equals(senderName)) {
                playerList.get(i).opponentUser = UserName;
                playerList.get(i).playChar = "X";

                ArrayList msg = new ArrayList();
                msg.add(4);
                msg.add(1);
                msg.add(senderName);//receiver
                msg.add(UserName);//sender
                msg.add(senderName);//who is playing with XXXXXXXXXXX
                playerList.get(i).mouth.println(gson.toJson(msg));
                break;
            }
        }
        opponentUser = senderName;
        playChar = "O";

        ArrayList msg = new ArrayList();
        msg.add(4);
        msg.add(1);
        msg.add(UserName);
        msg.add(senderName);
        msg.add(senderName);//who is playing with XXXXXXXXXXX

        mouth.println(gson.toJson(msg));

    }

    public void sendPlayAgainAccept() {
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).UserName.equals(opponentUser)) {
                ArrayList msg = new ArrayList();
                msg.add(11);
                msg.add(1);
                msg.add(0); // send to
                playerList.get(i).mouth.println(gson.toJson(msg));
                break;
            }
        }

        ArrayList msg = new ArrayList();
        msg.add(11);
        msg.add(1);
        msg.add(1);//send from
        mouth.println(gson.toJson(msg));
    }

    public void sendPlayAgainReject() {
        databaseSupplier.setIsPlay(UserName, opponentUser);
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).UserName.equals(opponentUser)) {
                ArrayList msg = new ArrayList();
                msg.add(11);
                msg.add(0);
                ArrayList<PlayerDetails> players = databaseSupplier.getOnlineUsers(playerList.get(i).UserName);
                msg.add(gson.toJson(players));
                playerList.get(i).mouth.println(gson.toJson(msg));
                break;
            }
        }
        ArrayList msg = new ArrayList();
        msg.add(11);
        msg.add(0);
        ArrayList<PlayerDetails> players = databaseSupplier.getOnlineUsers(UserName);
        msg.add(gson.toJson(players));
        mouth.println(gson.toJson(msg));
    }

    public void sendRejectRequest(String userName) {

        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).UserName.equals(userName)) {

                ArrayList msg = new ArrayList();
                msg.add(4);
                msg.add(0);
                msg.add(UserName);
                msg.add(userName);
                playerList.get(i).mouth.println(gson.toJson(msg));
                break;
            }
        }
    }

    public void sendPlayToAnotherPlayer(double index) {
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).UserName.equals(opponentUser)) {
                ArrayList msg = new ArrayList();
                msg.add(6);
                msg.add(index);
                playerList.get(i).mouth.println(gson.toJson(msg));

            }
        }
    }

    public void exitGame(boolean gameStatus) {
        ArrayList<PlayerDetails> players_player1 = databaseSupplier.getOnlineUsers(UserName);
        ArrayList<PlayerDetails> players_player2 = databaseSupplier.getOnlineUsers(opponentUser);
        databaseSupplier.setIsPlay(UserName, opponentUser);
        if (gameStatus) {
            for (int i = 0; i < playerList.size(); i++) {
                if (playerList.get(i).UserName.equals(opponentUser)) {
                    ArrayList msg = new ArrayList();
                    msg.add(8);
                    msg.add(1);
                    msg.add(UserName); // another name ;
                    msg.add(gson.toJson(players_player2));
                    playerList.get(i).mouth.println(gson.toJson(msg));
                }
            }

            ArrayList msg = new ArrayList();
            msg.add(8);
            msg.add(0);
            msg.add(gson.toJson(players_player1));
            mouth.println(gson.toJson(msg));
        } else {
            for (int i = 0; i < playerList.size(); i++) {
                if (playerList.get(i).UserName.equals(opponentUser)) {
                    ArrayList msg = new ArrayList();
                    msg.add(8);
                    msg.add(0);
                    msg.add(gson.toJson(players_player2));
                    playerList.get(i).mouth.println(gson.toJson(msg));
                }
            }

            ArrayList msg = new ArrayList();
            msg.add(8);
            msg.add(0);
            msg.add(gson.toJson(players_player1));
            mouth.println(gson.toJson(msg));

        }
    }

    synchronized public void updateScore(double score) {
        databaseSupplier.updateScore(score, UserName);
    }

    public void changePass(String str) {
        boolean passChangable = databaseSupplier.changePass(str);
        requestData.clear();
        requestData.add(15);
        requestData.add(passChangable);
        mouth.println(gson.toJson(requestData));
    }

    public void logout(String str) {
        boolean status = databaseSupplier.logOut(str);
        requestData.clear();
        requestData.add(16);
        requestData.add(status);
        mouth.println(gson.toJson(requestData));
    }

    synchronized public void closeConnection() {
        databaseSupplier.setDatabase();
        for (int i = 0; i < playerList.size(); i++) {
            gson = new Gson();
            ArrayList msg = new ArrayList();
            msg.add(0);
            msg.add("close");
            playerList.get(i).mouth.println(gson.toJson(msg));
        }

        for (int i = 0; i < playerList.size(); i++) {

            try {
                playerList.get(i).th.stop();
                playerList.get(i).clientSocket.close();

            } catch (IOException ex) {
                Logger.getLogger(ServerHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        playerList.clear();
        th.stop();

    }

}
