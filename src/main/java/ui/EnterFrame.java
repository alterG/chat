package ui;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_COLOR_BURNPeer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

/**
 * Created by alterG on 19.06.2017.
 */
public class EnterFrame extends JFrame {
    private static final int HEIGHT = 180;
    private static final int WIDTH = 280;
    public static final String SEND_BUTTON_NAME = "Send";
    private JButton connectButton;

    public EnterFrame() {
        setTitle("Chat enter");
        setSize(new Dimension(WIDTH, HEIGHT));
        setConfig();
    }

    private void setConfig() {
        setLayout(null);
        addComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setListeners();
    }

    private void setListeners() {
        connectButton.addActionListener( e -> {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            ChatFrame chatFrame = new ChatFrame();
        });
    }

    private void addComponents() {
        JLabel chatIpLabel = new JLabel("Chat IP");
        chatIpLabel.setBounds(20, 20, 60, 20);
        add(chatIpLabel);

        JLabel chatLoginLabel = new JLabel("Your login");
        chatLoginLabel.setBounds(20, 60, 60, 20);
        add(chatLoginLabel);

        JTextArea chatIpText = new JTextArea();
        chatIpText.setBounds(100, 20, 120, 20);
        add(chatIpText);

        JTextArea loginText = new JTextArea();
        loginText.setBounds(100, 60, 120, 20);
        add(loginText);

        connectButton = new JButton("Connect");
        connectButton.setBounds(20, 100, 100, 30);
        add(connectButton);
    }


}
