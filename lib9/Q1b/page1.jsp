<%@ page session="true" %>
<html>
<head>
    <title>Page 1</title>
</head>
<body>
    <h1>Page 1</h1>
    <form action="billing.jsp" method="post">
        <input type="hidden" name="page1Total" value="0">
        <p>Product 1: $100 <input type="number" name="qty1" value="1"></p>
        <p>Product 2: $200 <input type="number" name="qty2" value="1"></p>
        <p>Product 3: $300 <input type="number" name="qty3" value="1"></p>
        <input type="submit" value="Go to Billing">
    </form>
</body>
</html>