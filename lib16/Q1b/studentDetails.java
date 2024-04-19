import java.util.*;
import java.sql.*;

public class studentDetails {
    public static void main(String args[]) {
        Connection con = null;
        PreparedStatement ps = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter number of students: ");
            int nos = sc.nextInt();

            for (int i = 1; i <= nos; i++) {
                System.out.println("Pls Enter ENO");
                int a = sc.nextInt();
                System.out.println("Pls Enter ENAME");
                String b = sc.next();
                System.out.println("Pls Enter PERCENTAGE");
                int c = sc.nextInt();

                String query = "insert into student(rno, sname, percentage) values(?,?,?)";
                ps = con.prepareStatement(query);
                ps.setInt(1, a);
                ps.setString(2, b);
                ps.setInt(3, c);

                int n = ps.executeUpdate();

                if (n > 0)
                    System.out.println("RECORD INSERTED SUCCESSFULLY");
                else
                    System.out.println("RECORD NOT INSERTED");
            }

            String query2 = "select * from student where percentage=(select max(percentage) from student)";
            st = con.createStatement();
            rs = st.executeQuery(query2);

            System.out.println("DETAILS OF STUDENT HAVING MAXIMUM PERCENTAGE IS AS FOLLOWS");
            while (rs.next()) {
                System.out.println("Roll No: " + rs.getInt("rno") + ", Name: " + rs.getString("sname") + ", Percentage: " + rs.getInt("percentage"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
