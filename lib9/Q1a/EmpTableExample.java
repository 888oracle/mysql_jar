import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpTableExample {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String user = "myusername";
        String password = "mypassword";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            createEmpTable(connection);
            insertEmpRecord(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void createEmpTable(Connection connection) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS Emp (" +
                "ENo INT PRIMARY KEY," +
                "EName VARCHAR(50)," +
                "Sal DOUBLE)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.execute();
        }
    }

    private static void insertEmpRecord(Connection connection) throws SQLException {
        String sql = "INSERT INTO Emp (ENo, EName, Sal) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, 101);
            statement.setString(2, "John Smith");
            statement.setDouble(3, 50000.0);
            statement.executeUpdate();
        }
    }
}