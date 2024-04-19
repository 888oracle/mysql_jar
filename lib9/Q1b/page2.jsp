<%@ page import="java.util.*" %>
<html>
<head><title>Page 2</title></head>
<body>
<%
  int page2Total = 0;
%>

<%
  if (session.getAttribute("page2Total") != null) {
    page2Total = (Integer) session.getAttribute("page2Total");
  }
%>

<h3>Page 2 Total: $<%= page2Total %></h3>
<form method="post" action="billing.jsp">
 <input type="submit" value="Proceed to Checkout" name="submit">
</form>
</body>
</html>