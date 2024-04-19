<%@ page language="java" %>
<%
    String email = request.getParameter("email");
    if (email.contains("@") && email.contains(".")) {
        out.println("Valid email address");
    } else {
        out.println("Invalid email address");
    }
%>