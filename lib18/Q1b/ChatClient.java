package slips;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class ChatClient extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField messageField;
    private JTextArea displayArea;
    private BufferedReader in;
    private PrintWriter out;

    public ChatClient() {
        super("Chat Client");

        messageField = new JTextField(20);
        displayArea = new JTextArea();

        add(messageField, BorderLayout.NORTH);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        try (Socket socket = new Socket("localhost", 1234)) {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            Thread readThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = in.readLine()) != null) {
                        displayArea.append("Server: " + message + "\n");
                    }
                } catch (IOException e) {
                    System.err.println("Error: " + e.getMessage());
                }
            });
            readThread.start();

            messageField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String message = messageField.getText();
                    out.println(message);
                    displayArea.append("Client: " + message + "\n");messageField.setText("");
                }
            });

        } catch (UnknownHostException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new ChatClient();
    }
}