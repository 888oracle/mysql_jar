<!DOCTYPE html>
<html>
<head>
    <title>Reverse String</title>
</head>
<body>
    <h2>Enter a string:</h2>
    <form action="reverse.jsp" method="post">
        <input type="text" name="inputString">
        <button type="submit">Reverse</button>
    </form>

    <h2>Reversed String:</h2>
    <%
        String inputString = request.getParameter("inputString");
        if (inputString != null) {
            String reversedString = new StringBuilder(inputString).reverse().toString();
    %>
            <p><%= reversedString %></p>
    <%
        }
    %>
</body>
</html>
