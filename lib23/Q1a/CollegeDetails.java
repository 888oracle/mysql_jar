//Add mysql-connector jar
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
public class CollegeDetails extends JFrame {
   private JTable collegeTable;
   private JScrollPane scrollPane;
   public CollegeDetails(ArrayList<College> colleges) {
       setTitle("College Details");
       setSize(600, 400);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
       setLayout(new BorderLayout());
       // Create table model with column names
       DefaultTableModel model = new DefaultTableModel();
       model.addColumn("CID");
       model.addColumn("CName");
       model.addColumn("Address");
       model.addColumn("Year");
       // Populate table model with college data
       for (College college : colleges) {
           Object[] rowData = {college.getCID(), college.getCName(), college.getAddress(), college.getYear()};
           model.addRow(rowData);
       }
       // Create JTable with table model
       collegeTable = new JTable(model);
       // Add JTable to JScrollPane
       scrollPane = new JScrollPane(collegeTable);
       // Add JScrollPane to JFrame
       add(scrollPane, BorderLayout.CENTER);
   }
   public static void main(String[] args) {
       // Sample college data with Indian names
       ArrayList<College> colleges = new ArrayList<>();
       colleges.add(new College(1, "St. Xavier's College", "Mumbai, Maharashtra", 1859));
       colleges.add(new College(2, "Indian Institute of Technology Bombay (IIT Bombay)", "Powai, Mumbai", 1958));
       // Create and display GUI
       SwingUtilities.invokeLater(() -> {
           CollegeDetails collegeDetails = new CollegeDetails(colleges);
           collegeDetails.setVisible(true);
       });
   }
}
class College {
   private int CID;
   private String CName;
   private String address;
   private int year;
   public College(int CID, String CName, String address, int year) {
       this.CID = CID;
       this.CName = CName;
       this.address = address;
       this.year = year;
   }
   public int getCID() {
       return CID;
   }
   public String getCName() {
       return CName;
   }
   public String getAddress() {
       return address;
   }
   public int getYear() {
       return year;
   }
}
