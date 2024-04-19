import java.sql.*;

public class SalesDetails {

    // JDBC connection parameters
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name";
    static final String USER = "your_username";
    static final String PASS = "your_password";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // Prepare and execute SQL query
            stmt = conn.createStatement();
            String sql = "SELECT PID, PName, Qty, Rate, Amount FROM Sales WHERE SaleDate BETWEEN ? AND ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1, java.sql.Date.valueOf("2024-01-01")); // Start date
            pstmt.setDate(2, java.sql.Date.valueOf("2024-03-31")); // End date
            ResultSet rs = pstmt.executeQuery();

            // Display sales details
            System.out.println("PID\tPName\tQty\tRate\tAmount");
            while (rs.next()) {
                int PID = rs.getInt("PID");
                String PName = rs.getString("PName");
                int Qty = rs.getInt("Qty");
                double Rate = rs.getDouble("Rate");
                double Amount = rs.getDouble("Amount");
                System.out.println(PID + "\t" + PName + "\t" + Qty + "\t" + Rate + "\t" + Amount);
            }

            // Clean-up environment
            rs.close();
            pstmt.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
