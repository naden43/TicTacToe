package tictactoeserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
