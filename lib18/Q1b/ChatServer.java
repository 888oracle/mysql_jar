package slips;

import java.awt.BorderLayout;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class ChatServer extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea displayArea;
    private List<ClientHandler> clients;

    public ChatServer() {
        super("Chat Server");
        displayArea = new JTextArea();
        clients = new ArrayList<>();

        add(displayArea, BorderLayout.CENTER);

        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        try (ServerSocket listener = new ServerSocket(1234)) {
            while (true) {
                new ClientHandler(listener.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void broadcast(String message) {
        for (ClientHandler client : clients) {
            client.sendMessage(message);
        }
    }

    public static void main(String[] args) {
        new ChatServer();
    }

    class ClientHandler extends Thread {

        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    displayArea.append("Client: " + message + "\n");
                    broadcast(message);
                }

            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            } finally {
                if (socket != null) {
                   try {
                        socket.close();
                    } catch (IOException e) {
                        System.err.println("Error: " + e.getMessage());
                    }
                }
                clients.remove(this);
            }
        }

        public void sendMessage(String message) {
            out.println(message);
        }
    }
}