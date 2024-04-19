<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Number to Words Converter</title>
</head>
<body>
    <h2>Number to Words Converter</h2>
    
    <form action="convertNumber.jsp" method="post">
        Enter a number:
        <input type="number" name="number" required>
        <input type="submit" value="Convert">
    </form>
</body>
</html>
