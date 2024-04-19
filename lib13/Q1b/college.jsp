<%@page import="java.sql.*"%> 

<%
if(request.getParameter("s1")!=null)
  {
		Connection con;
		Statement st;
		String query;
		ResultSet rs;
		
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","");
		st = con.createStatement();
		query = "select * from college";
		rs = st.executeQuery(query);
%>
<table border=l> 
<tr><th>Roll No</th><th>Name</th><th>Address </th></tr> 
<%
while(rs.next()) 
{
%>
<tr> 
<td><%=rs.getInt("Roll No")%></td> 
<td><%=rs.getString("Name")%></td> 
<td><%=rs.getString("Address")%></td> 
</tr> 
<%
}
	st.close();		
	con.close();
}
%>
 </table>
