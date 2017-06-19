package server.thread;

import protocol.Packet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Map;

/**
 * Created by alterG on 19.06.2017.
 */
public class ServerUserThread extends Thread {
    private Socket socket;
    private Map<String, ServerUserThread> connectedUsersMap;
    private ObjectOutputStream oos;

    public ServerUserThread(Socket socket, Map<String, ServerUserThread> connectedUsersMap) throws IOException {
        this.socket = socket;
        this.connectedUsersMap = connectedUsersMap;
        oos = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

            // read message from client
            Packet packet = (Packet) ois.readObject();

            processPacket(packet);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void processPacket(Packet packet) throws IOException {
        String userLogin = packet.userLogin;;
        String userMessage;
        String responseMessage;

        switch (packet.type) {
            case CONNECT:
                connectedUsersMap.put(userLogin, this);
                responseMessage = String.format("User %s has joined to chat.\n", userLogin);
                sendChatUpdates(responseMessage, connectedUsersMap);
                break;
            case MESSAGE:
                userMessage = packet.message;
                responseMessage = String.format("%s: %s\n", userLogin, userMessage);
                sendChatUpdates(responseMessage, connectedUsersMap);
                break;
        }

    }

    private void sendChatUpdates(String message, Map<String, ServerUserThread> connectedUsersMap) throws IOException {
        for (String user : connectedUsersMap.keySet()) {
            Packet response = new Packet(message, Packet.Type.MESSAGE);

            // Send response
            ObjectOutputStream userOutputStream = connectedUsersMap.get(user).oos;
            userOutputStream.writeObject(response);
            userOutputStream.flush();
        }
    }

}
