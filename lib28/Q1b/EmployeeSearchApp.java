package slips;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeSearchApp extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField searchField;
    private JButton searchButton;
    private JTable resultTable;
    private DefaultTableModel tableModel;

    public EmployeeSearchApp() {
        setTitle("Employee Search");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());

        JLabel searchLabel = new JLabel("Search by EmpNo:");
        searchPanel.add(searchLabel);

        searchField = new JTextField(10);
        searchPanel.add(searchField);

        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchEmployee();
            }
        });
        searchPanel.add(searchButton);

        add(searchPanel, BorderLayout.NORTH);

        // Create table
        tableModel = new DefaultTableModel(new Object[]{"Eno", "Ename", "Salary"}, 0);
        resultTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(resultTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void searchEmployee() {
        // Code to search employee by employee number
        // For demonstration purposes, let's just display a dummy employee
        String empNo = searchField.getText();
        String ename = "";
        String salary = "";

        // Clear previous results
        tableModel.setRowCount(0);

        // Add new row with employee details
        tableModel.addRow(new Object[]{empNo, ename, salary});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EmployeeSearchApp().setVisible(true);
            }
        });
    }
}
