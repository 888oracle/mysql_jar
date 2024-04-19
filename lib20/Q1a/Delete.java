import java.util.*;
import java.sql.*;

public class Delete {
    public static void main(String args[]) {
        Connection con = null;
        PreparedStatement ps = null;
        String query = null;

        Scanner sc = new Scanner(System.in);
        try {
            // Accept employee ID from command line argument
            int a = Integer.parseInt(args[0]);

            // Load and register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Create the database connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");

            // Prepare the SQL query
            query = "DELETE FROM emp WHERE eno = ?";

            // Create the prepared statement
            ps = con.prepareStatement(query);

            // Set the employee ID parameter
            ps.setInt(1, a);

            // Execute the query
            int n = ps.executeUpdate();

            // Check if any record is deleted
            if (n > 0)
                System.out.println(n + " RECORD(s) DELETED SUCCESSFULLY");
            else
                System.out.println("NO RECORD DELETED");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please provide a valid employee ID.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please provide the employee ID as a command line argument.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the statement and connection
            try {
                if (ps != null)
                    ps.close();
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
