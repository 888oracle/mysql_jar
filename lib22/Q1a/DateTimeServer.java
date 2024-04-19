import java.net.*;
import java.io.*;
import java.util.*;

class DateTimeServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5917);
        Socket socket = serverSocket.accept();
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        Date currentDate = new Date();
        dos.writeUTF(currentDate.toString());
        dos.flush(); // Make sure to flush the stream
        dos.close(); // Close the stream
        serverSocket.close(); // Close the server socket
    }
}
