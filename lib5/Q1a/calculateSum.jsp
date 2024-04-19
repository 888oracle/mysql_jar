<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sum Result</title>
</head>
<body>
    <%
        // Get the number from the request parameter
        int number = Integer.parseInt(request.getParameter("number"));

        // Calculate the first and last digits
        int lastDigit = number % 10;
        int firstDigit = 0;
        while (number != 0) {
            firstDigit = number;
            number /= 10;
        }

        // Calculate the sum
        int sum = firstDigit + lastDigit;
    %>

    <h2>Sum Result</h2>
    <p style="color: red; font-size: 18px;">
        Sum of first and last digit of <%= request.getParameter("number") %> is <%= sum %>
    </p>
</body>
</html>
