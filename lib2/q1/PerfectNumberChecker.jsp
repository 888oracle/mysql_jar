<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Perfect Number Checker</title>
</head>
<body>
    <h1>Perfect Number Checker</h1>
    <form action="PerfectNumberChecker.jsp" method="post">
        Enter a number: <input type="text" name="num">
        <input type="submit" value="Check">
    </form>
    <%
        String num = request.getParameter("num");
        if (num != null && !num.equals("")) {
            int number = Integer.parseInt(num);
            int sum = 0;
            for (int i = 1; i < number; i++) {
                if (number % i == 0) {
                    sum += i;
                }
            }
            if (sum == number) {
                out.print("<p>The number " + number + " is a perfect number.</p>");
            } else {
                out.print("<p>The number " + number + " is not a perfect number.</p>");
            }
        }
    %>
</body>
</html>