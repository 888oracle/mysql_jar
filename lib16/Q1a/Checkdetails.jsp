<%@ page import="javax.servlet.*" %>
<%@ page session="true" %>
<html>
<head>
<title>Check Credentials</title>
</head>
<body>
<%
    String uid = request.getParameter("id");
    String password = request.getParameter("pass");
    session.setAttribute("session-uid", uid);
    if (uid != null && password != null && uid.equals("Sofiya") && password.equals("Shaikh")) {
        response.sendRedirect("success.jsp");
    } else {
        response.sendRedirect("failed.jsp");
    }
%>
</body>
</html>
