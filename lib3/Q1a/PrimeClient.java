import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class PrimeClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8000);

        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        int number = 17;
        writer.println(number);

        String response = reader.readLine();
        System.out.println(response);

        socket.close();
    }
}