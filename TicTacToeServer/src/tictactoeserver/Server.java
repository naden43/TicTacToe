/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoeserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Server extends Thread {

    ServerSocket serverSocket;
    ServerHandler serverHandler;

    public Server() {
        try {
            serverSocket = new ServerSocket(5010);
            start();
        } catch (IOException ex) {
            System.out.println("Aser");
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close() {

        try {
            if (!serverHandler.playerList.isEmpty()) {
                serverHandler.closeConnection();
            }
            stop();

            serverSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void run() {
        while (true) {
            Socket socket;
            try {
                socket = serverSocket.accept();
                serverHandler = new ServerHandler(socket);

            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
