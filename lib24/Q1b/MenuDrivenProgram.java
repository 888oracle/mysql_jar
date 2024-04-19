package com.jdbc.student;
import java.sql.*;
import java.util.Scanner;
class EmpManagement {
Connection conn;
Statement stmt;
Scanner sc = new Scanner(System.in);
public EmpManagement() throws SQLException, ClassNotFoundException {
Class.forName("com.mysql.cj.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "username", "pasword");
stmt = conn.createStatement();
}
void insertRecord() throws SQLException {
System.out.print("Enter ENo: ");
int ENo = sc.nextInt();
System.out.print("Enter EName: ");
String EName = sc.next();
System.out.print("Enter salary: ");
int salary = sc.nextInt();
System.out.print("Enter Desg: ");
String Desg = sc.next();
stmt.executeUpdate("INSERT INTO emp VALUES (" + ENo + ", '" + EName + "', " + salary + ", '" + Desg + "')");
System.out.println("Record inserted successfully.");
}
void updateRecord() throws SQLException {
System.out.print("Enter ENo of the record you want to update: ");
int ENo = sc.nextInt();
System.out.print("Enter new EName: ");
String EName = sc.next();
System.out.print("Enter new salary: ");
int Salary = sc.nextInt();
System.out.print("Enter new Desg: ");
String Desg = sc.next();
stmt.executeUpdate("UPDATE emp SET EName='" + EName + "', Salary=" + Salary + ", Desg='" + Desg + "' WHERE ENo=" + ENo);
System.out.println("Record updated successfully.");
}
void deleteRecord() throws SQLException {
System.out.print("Enter ENo of the record you want to delete: ");
int ENo = sc.nextInt();
stmt.executeUpdate("DELETE FROM emp WHERE ENo=" + ENo);
System.out.println("Record deleted successfully.");
}
void searchRecord() throws SQLException {
System.out.print("Enter ENo of the record you want to search: ");
int ENo = sc.nextInt();
ResultSet rs = stmt.executeQuery("SELECT * FROM emp WHERE ENo=" + ENo);
if (rs.next()) {
System.out.println("ENo: " + rs.getInt(1));
System.out.println("EName: " + rs.getString(2));
System.out.println("salary: " + rs.getInt(3));
System.out.println("Desg: " + rs.getString(4));
} else {
System.out.println("Record not found.");
}
}
void displayRecords() throws SQLException {
ResultSet rs = stmt.executeQuery("SELECT * FROM emp");
while (rs.next()) {
System.out.println("ENo: " + rs.getInt(1));
System.out.println("EName: " + rs.getString(2));
System.out.println("salary: " + rs.getInt(3));
System.out.println("Desg: " + rs.getString(4));
System.out.println("-------------------");
}
}
void exit() throws SQLException {
System.out.println("Exiting...");
conn.close();
}
}
public class MenuDrivenProgram {
@SuppressWarnings("resource")
public static void main(String[] args) {
try {
EmpManagement empManagement = new EmpManagement();
int choice;
do {
System.out.println("1. Insert");
System.out.println("2. Update");
System.out.println("3. Delete");
System.out.println("4. Search");
System.out.println("5. Display");
System.out.println("6. Exit");
System.out.print("Enter your choice: ");
choice = new Scanner(System.in).nextInt();
switch (choice) {
case 1:
empManagement.insertRecord();
break;
case 2:
empManagement.updateRecord();
break;
case 3:
empManagement.deleteRecord();
break;
case 4:
empManagement.searchRecord();
break;
case 5:
empManagement.displayRecords();
break;
case 6:
empManagement.exit();
break;
default:
System.out.println("Invalid choice.");
}           
} while (choice != 6);
}   
       catch(Exception e)
       {
       	e.printStackTrace();
       }
   }
}


