import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DDLQueryGUI {
    private JTextField queryField;
    private JButton createButton;
    private JButton alterButton;
    private JButton dropButton;
    private static Connection conn;

    public DDLQueryGUI() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase", "username", "password");
        } catch (Exception e) {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("DDL Query");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        queryField = new JTextField(20);
        createButton = new JButton("Create Table");
        alterButton = new JButton("Alter Table");
        dropButton = new JButton("Drop Table");

        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String query = queryField.getText().trim();
                if (query.toLowerCase().startsWith("create table")) {
                    try {
                        Statement stmt = conn.createStatement();
                        stmt.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Table created successfully!");
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid CREATE TABLE query!");
                }
            }
        });

        alterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String query = queryField.getText().trim();
                if (query.toLowerCase().startsWith("alter table")) {
                    try {
                        Statement stmt = conn.createStatement();
                        stmt.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Table altered successfully!");
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid ALTER TABLE query!");
                }
            }
        });

        dropButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String query = queryField.getText().trim();
                if (query.toLowerCase().startsWith("drop table")) {
                    try {
                        Statement stmt = conn.createStatement();
                        stmt.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Table dropped successfully!");
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, "Error: " + e1.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a valid DROP TABLE query!");
                }
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3));
        panel.add(createButton);
        panel.add(alterButton);
        panel.add(dropButton);

        frame.add(queryField, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new DDLQueryGUI();
    }
}

//DDL query:
//	CREATE TABLE Book (
//		    BookID INT PRIMARY KEY,
//		    Title VARCHAR(100),
//		    Author VARCHAR(100),
//		    PublicationYear INT,
//		    Genre VARCHAR(50),
//		    ISBN VARCHAR(20),
//		    Price DECIMAL(10, 2)
//		);



