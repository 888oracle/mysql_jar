<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account Details</title>
</head>
<body>
    <h2>Enter Account Details</h2>
    <form method="post" action="AccountDetails.jsp">
        Account Number: <input type="text" name="accountNo"><br>
        Type: <input type="text" name="type"><br>
        Balance: <input type="text" name="balance"><br>
        <input type="submit" value="Submit">
    </form>

    <%
        // Retrieve form data
        String accountNo = request.getParameter("accountNo");
        String type = request.getParameter("type");
        String balance = request.getParameter("balance");
        
        // Check if form is submitted
        if (accountNo != null && type != null && balance != null) {
            // Database connection parameters
            String url = "jdbc:mysql://localhost:3306/testdb";
            String username = "root";
            String password = "";
            
            // Establish connection
            Connection con = DriverManager.getConnection(url, username, password);
            
            // Insert account details into database
            PreparedStatement ps = con.prepareStatement("INSERT INTO account (ANo, Type, Bal) VALUES (?, ?, ?)");
            ps.setString(1, accountNo);
            ps.setString(2, type);
            ps.setString(3, balance);
            ps.executeUpdate();
            ps.close();
            
            // Retrieve all accounts from database
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM account");
    %>
    
    <h2>Account Details</h2>
    <table border="1">
        <tr>
            <th>Account Number</th>
            <th>Type</th>
            <th>Balance</th>
        </tr>
    <% while(rs.next()) { %>
        <tr>
            <td><%= rs.getString("ANo") %></td>
            <td><%= rs.getString("Type") %></td>
            <td><%= rs.getString("Bal") %></td>
        </tr>
    <% } %>
    </table>
    
    <%
            // Close database resources
            rs.close();
            stmt.close();
            con.close();
        }
    %>
</body>
</html>
