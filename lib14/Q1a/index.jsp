<html>
	<body>
		<font color=red>
		<%
			String name=request.getParameter("name");
			String age=request.getParameter("age");

			int ag=Integer.parseInt(age);
			if(ag>=18)
				out.println("voter is eligible for voting");
			else
				out.println("voter is not eligible for voting");
			
		%>
</font>
</body>
</html>