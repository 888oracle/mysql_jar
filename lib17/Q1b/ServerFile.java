import java.io.*;
import java.net.*;

class ServerFile {
    public static void main(String args[]) {
        try {
            ServerSocket server = new ServerSocket(7777);
            System.out.println("Server started. Waiting for client...");
            Socket s = server.accept();

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            String sfilename = dis.readUTF();
            File file = new File(sfilename);

            if (file.exists()) {
                FileInputStream fin = new FileInputStream(sfilename);
                StringBuilder fileinfo = new StringBuilder();

                int ch;
                while ((ch = fin.read()) != -1) {
                    fileinfo.append((char) ch);
                }

                System.out.println("Sending file contents to client...");
                dos.writeUTF(fileinfo.toString());

                // Close resources
                fin.close();
            } else {
                System.out.println("File not found.");
                dos.writeUTF("0");
            }

            // Close resources
            dis.close();
            dos.close();
            s.close();
            server.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
