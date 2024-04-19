import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ProductDetailsServlet")
public class ProductDetailsServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
  
   // JDBC URL, username, and password of MySQL server
   private static final String JDBC_URL = "jdbc:mysql://localhost:3306/productdb";
   private static final String JDBC_USER = "root";
   private static final String JDBC_PASSWORD = "sharvipw#2003";
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       out.println("<html><head><title>Product Details</title></head><body>");
       out.println("<h1>Product Details</h1>");
       Connection conn = null;
       PreparedStatement stmt = null;
       ResultSet rs = null;
       try {
           // Load the MySQL JDBC driver
           Class.forName("com.mysql.jdbc.Driver");
           // Establish connection to MySQL database
           conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
           // SQL query to retrieve all products
           String sql = "SELECT ProdCode, PName, Price FROM products";
           stmt = conn.prepareStatement(sql);
           rs = stmt.executeQuery();
           // Display products in a table
           out.println("<table border='1'><tr><th>Product Code</th><th>Product Name</th><th>Price</th></tr>");
           while (rs.next()) {
               out.println("<tr><td>" + rs.getString("ProdCode") + "</td><td>" + rs.getString("PName") + "</td><td>"
                       + rs.getDouble("Price") + "</td></tr>");
           }
           out.println("</table>");
       } catch (ClassNotFoundException | SQLException e) {
           e.printStackTrace();
           out.println("Error: " + e.getMessage());
       } finally {
           // Close JDBC objects
           try {
               if (rs != null) {
                   rs.close();
               }
               if (stmt != null) {
                   stmt.close();
               }
               if (conn != null) {
                   conn.close();
               }
           } catch (SQLException e) {
               e.printStackTrace();
           }
       }
       out.println("</body></html>");
   }
}

