import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        final String SERVER_IP = "localhost";
        final int PORT = 12345;

        try (Socket socket = new Socket(SERVER_IP, PORT);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            // Prompt the user to enter a number
            System.out.print("Enter a number: ");
            int number = Integer.parseInt(userInput.readLine());

            // Send the number to the server
            out.println(number);

            // Receive and display factors from the server
            System.out.println("Factors: " + in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
