import java.sql.*;

public class CollegeNamesDisplay {

    public static void main(String[] args) {
        // JDBC connection parameters
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String user = "your_username";
        String password = "your_password";

        // SQL query to select college names
        String query = "SELECT CName FROM College";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Display college names
            System.out.println("List of College Names:");
            while (resultSet.next()) {
                String collegeName = resultSet.getString("CName");
                System.out.println(collegeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
