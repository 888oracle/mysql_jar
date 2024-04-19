import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class StudentAwtJdbc extends Frame implements ActionListener {
    Label l1;
    TextField t1, t2;
    Button b1;

    public StudentAwtJdbc() {
        setLayout(null);
        setSize(800, 600);
        setTitle("Record Display");
        setVisible(true);

        l1 = new Label("ENTER ENO");
        l1.setBounds(100, 200, 150, 50);
        add(l1);

        t1 = new TextField();
        t1.setBounds(500, 200, 150, 50);
        add(t1);

        t2 = new TextField();
        t2.setBounds(300, 300, 400, 50);
        add(t2);

        b1 = new Button("DISPLAY");
        b1.setBounds(300, 400, 150, 50);
        add(b1);
        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        String cap = ae.getActionCommand();
        if (cap.equals("DISPLAY")) {
            try {
                Connection con;
                PreparedStatement ps;
                String query;
                ResultSet rs;

                int a = Integer.parseInt(t1.getText());

                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "");

                query = "select * from student where rno = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, a);

                rs = ps.executeQuery();
                if (rs.next()) {
                    t2.setText(rs.getInt("rno") + " " + rs.getString("sname") + " " + rs.getFloat("percentage"));
                } else {
                    t2.setText("No record found for the given ENO");
                }

                ps.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        new StudentAwtJdbc();
    }
}
