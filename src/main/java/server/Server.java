package server;

import server.thread.ServerUserThread;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by alterG on 19.06.2017.
 */
public class Server {
    private final static int PORT = 1314;
    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {

        Server server = new Server();
        while (true) {
            server.waitClient();
        }
    }

    public Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.printf("Server has started successfully. Address: %s:%d", inetAddress.getHostAddress(), PORT);
    }

    protected void waitClient() throws IOException {

        Socket clientSocket = serverSocket.accept();
        ServerUserThread serverUserThread = new ServerUserThread();

    }

}
