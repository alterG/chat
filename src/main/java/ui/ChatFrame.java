package ui;

import javax.swing.*;
import java.awt.*;

/**
 * Frame contains only ChatPanel
 * Created by alterG on 19.06.2017.
 */
public class ChatFrame extends JFrame {

    private static final int HEIGHT = 500;
    private static final int WIDTH = 500;
    public static final String SEND_BUTTON_NAME = "Send";

    public ChatFrame() {
        setTitle("Chat v1.0");
        setSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        addComponents();

        setVisible(true);

    }

    private void addComponents() {

        // add chat area
        JTextArea chatArea = new JTextArea();
        chatArea.setBounds(20, 20, 300, 300);
        this.add(chatArea);

        // add user input area
        JTextArea userInputArea = new JTextArea();
        userInputArea.setBounds(20, 360, 300, 60);
        this.add(userInputArea);

        // add users list label
        JLabel usersListLabel = new JLabel("Users list:");
        usersListLabel.setBounds(360, 20, 320, 300);
        usersListLabel.setVerticalAlignment(JLabel.TOP);
        this.add(usersListLabel);

        // add sent button
        JButton sendButton = new JButton(SEND_BUTTON_NAME);
        sendButton.setBounds(360, 360, 80, 30);
        this.add(sendButton);
    }

}
