<%@ page session="true" %>
<html>
<head>
    <title>Billing</title>
</head>
<body>
    <h1>Billing</h1>
    <%
    double page1Total = session.getAttribute("page1Total") != null ? (double) session.getAttribute("page1Total") : 0;
    double page2Total = session.getAttribute("page2Total") != null ? (double) session.getAttribute("page2Total") : 0;
    double total = page1Total + page2Total;
%>
    <p>Page 1 Total: $<%= page1Total %></p>
    <p>Page 2 Total: $<%= page2Total %></p>
    <p>Total: $<%= total %></p>
</body>
</html>