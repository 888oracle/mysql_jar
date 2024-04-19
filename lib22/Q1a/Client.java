import java.net.*;
import java.io.*;

class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5917);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String receivedDate = dis.readUTF();
        System.out.println("Date and Time from server: " + receivedDate);
        dis.close(); // Close the input stream
        socket.close(); // Close the socket
    }
}
