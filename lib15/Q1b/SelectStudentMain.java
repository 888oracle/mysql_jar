import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class StudendAwtJdbc extends Frame implements ActionListener
{
Label l1,l2,l3,l4;
TextField t1,t2,t3;
Button b1;

public StudendAwtJdbc()
{
setLayout(null);
setSize(800,600);
setTitle("Insert Record");
setVisible(true);

l1=new Label("ENTER ENO");
l1.setBounds(100,100,300,50);
add(l1);

l2=new Label("ENTER ENAME");
l2.setBounds(100,200,300,50);
add(l2);

l3=new Label("ENTER SAL");
l3.setBounds(100,300,300,50);
add(l3);

l4=new Label("ANSWERS");
l4.setBounds(50,50,300,50);
add(l4);

t1=new TextField();
t1.setBounds(500,100,200,50);
add(t1);

t2=new TextField();
t2.setBounds(500,200,200,50);
add(t2);

t3=new TextField();
t3.setBounds(500,300,200,50);
add(t3);

b1=new Button("SEARCH");
b1.setBounds(300,400,200,50);
add(b1);
b1.addActionListener(this);

}

public void actionPerformed(ActionEvent ae)
{
	String cap=ae.getActionCommand();
	if(cap.equals("SEARCH"))
	{
		try
		{
	Connection con;
	PreparedStatement ps;
	String query;
	
	ResultSet rs;
	
	
	int a;
	a=Integer.parseInt(t1.getText());
	
	Class.forName("com.mysql.jdbc.Driver");  //step 2 load & register the db driver
	
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root",""); //step 3 create the connection
	
	query="select * from emp where eno like ?"; //step 5 - make the query
		
	ps=con.prepareStatement(query);  //step 4 create the statement
	
	ps.setInt(1,a);
	
	
	rs=ps.executeQuery(); // step 6 fire the query
	if(rs.next())
	{
	t2.setText(rs.getString("ename"));
	t3.setText(rs.getFloat("sal")+"");
	}
	
	ps.close();		//step 7 close the statement and connections
	con.close();
 		}catch(Exception e){}
		
	}
	}
}



public class SelectStudentMain
{
	public static void main(String args[])
	{
	new StudendAwtJdbc();
	}
}
