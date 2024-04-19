import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Scrollable {

    public static void main(String[] args) {
        // JDBC connection parameters
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String user = "your_username";
        String password = "your_password";

        // SQL query to select all records from the Teacher table
        String query = "SELECT * FROM Teacher";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet resultSet = statement.executeQuery(query)) {

            // Move to the last row
            resultSet.last();

            // Get the total number of rows
            int rowCount = resultSet.getRow();

            System.out.println("Total number of rows: " + rowCount);

            // Move the cursor to the first row
            resultSet.beforeFirst();

            // Iterate over the result set
            while (resultSet.next()) {
                int tid = resultSet.getInt("TID");
                String tname = resultSet.getString("TName");
                double salary = resultSet.getDouble("Salary");
                String subject = resultSet.getString("Subject");

                System.out.println("TID: " + tid + ", TName: " + tname + ", Salary: " + salary + ", Subject: " + subject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
