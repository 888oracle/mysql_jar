<%@ page import="java.util.*" %>
<html>
    <body>
        <%
            Date time = new Date();
            String n = request.getParameter("name");
            if (time.getHours() >= 0 && time.getHours() < 12) {
                out.println("Good Morning!!! " + n);
            } else if (time.getHours() >= 12 && time.getHours() < 16) {
                out.println("Good Afternoon!!! " + n);
            } else if (time.getHours() >= 16 && time.getHours() < 20) {
                out.println("Good Evening!!! " + n);
            } else {
                out.println("Good Night!!! " + n);
            }
        %>
    </body>
</html>
