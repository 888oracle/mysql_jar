import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Take input from the user
        // Create an instance of the Scanner Class
        Scanner sc = new Scanner(System.in);
        // Declare and Initialize the variable
        System.out.println("Enter the number: ");
        int num = sc.nextInt();
        int i = 1, fact = 1;
        while (i <= num) {
            fact = fact * i;
            System.out.println("Calculating factorial...");
            try {
                Thread.sleep(1000); // Sleep for 1 second (1000 milliseconds)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
        System.out.println("Factorial of the number: " + fact);
    }
}
