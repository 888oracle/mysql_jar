import java.net.InetAddress;

public class ClientMachineInfo {
    public static void main(String[] args) {
        try {
            InetAddress my_address = InetAddress.getLocalHost();
            System.out.println("The IP address is : " + my_address.getHostAddress());
            System.out.println("The host name is : " + my_address.getHostName());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}