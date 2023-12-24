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
public class Server {

    ServerSocket serverSocket;

    public Server() {
        try {
            serverSocket = new ServerSocket(5010);
            while (true) {
                Socket socket = serverSocket.accept();
                new ServerHandler(socket);
               
            }
        } catch (IOException ex) {
            System.out.println("Aser");
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
