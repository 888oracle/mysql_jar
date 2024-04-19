<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Teacher Details</title>
</head>
<body>
    <h2>Teacher Details</h2>
    <table border="1">
        <tr>
            <th>Teacher ID</th>
            <th>Teacher Name</th>
            <th>Designation</th>
            <th>Subject</th>
            <th>Qualification</th>
        </tr>
        <tr>
            <td><%= request.getParameter("tid") %></td>
            <td><%= request.getParameter("tname") %></td>
            <td><%= request.getParameter("desg") %></td>
            <td><%= request.getParameter("subject") %></td>
            <td><%= request.getParameter("qualification") %></td>
        </tr>
    </table>
</body>
</html>
