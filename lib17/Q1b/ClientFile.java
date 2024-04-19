import java.io.*;
import java.net.*;
import java.util.*;

public class ClientFile {
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        try {
            Socket client = new Socket("localhost", 7777);
            DataInputStream dis = new DataInputStream(client.getInputStream());
            DataOutputStream dos = new DataOutputStream(client.getOutputStream());

            System.out.println("Please enter a file name:");
            String cfilename = sc.next();

            dos.writeUTF(cfilename);
            String msg = dis.readUTF();

            if (msg.equalsIgnoreCase("0"))
                System.out.println("File does not exist.");
            else
                System.out.println("File Contents:\n" + msg);

            // Close resources
            dis.close();
            dos.close();
            client.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
