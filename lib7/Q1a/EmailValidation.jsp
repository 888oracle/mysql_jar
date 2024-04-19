<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Email Validation</title>
    <script type="text/javascript">
        function validateEmail() {
            var email = document.getElementById("email").value;
            var regex = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/;
            if (regex.test(email)) {
                return true;
            } else {
                alert("Invalid email address");
                return false;
            }
        }
    </script>
</head>
<body>
    <form action="CheckEmail.jsp" onsubmit="return validateEmail()" method="post">
        Email: <input type="text" id="email" name="email"><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>