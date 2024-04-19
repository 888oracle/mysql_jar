<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Number to Words Result</title>
</head>
<body>
    <h2>Number to Words Result</h2>
    
    <%-- Retrieve number from the form --%>
    <% String numberString = request.getParameter("number");
       int number = Integer.parseInt(numberString);
    %>
    
    <%-- Convert the number to words --%>
    <% String words = convertToWords(number); %>
    
    <%-- Display the result in red color --%>
    <p style="color:red;"><%= words %></p>
    
    <%-- Function to convert number to words --%>
    <%!
        public String convertToWords(int number) {
            // Define an array to store the words for numbers 0 to 9
            String[] wordsArray = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

            // Convert the number to words
            StringBuilder wordsBuilder = new StringBuilder();
            while (number > 0) {
                int digit = number % 10;
                wordsBuilder.insert(0, wordsArray[digit] + " ");
                number /= 10;
            }

            return wordsBuilder.toString();
        }
    %>
</body>
</html>
