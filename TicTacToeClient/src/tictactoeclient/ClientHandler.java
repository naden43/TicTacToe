package tictactoeclient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandler {

    DataInputStream ear;
    PrintStream mouth;
    Socket socket;
    Integer id ;
    public ClientHandler() {

        try {
            socket = new Socket("127.0.0.1", 5010);
            ear = new DataInputStream(socket.getInputStream());
            mouth = new PrintStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

        new Thread() {
            public void run() {      
                    try {
                        String s = "i am a new client";
                        mouth.println(s);
                        String msg = ear.readLine();
                        System.out.println(msg);
                        id = Integer.parseInt(msg);
                        
                    } catch (IOException ex) {
                        Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
            }
        }.start();

    }

}
