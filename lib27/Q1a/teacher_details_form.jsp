<!DOCTYPE html>
<html>
<head>
    <title>Teacher Details Form</title>
</head>
<body>
    <h2>Enter Teacher Details</h2>
    <form action="DisplayTeacherDetails.jsp" method="post">
        <label for="tid">Teacher ID:</label>
        <input type="text" id="tid" name="tid" required><br><br>
        
        <label for="tname">Teacher Name:</label>
        <input type="text" id="tname" name="tname" required><br><br>
        
        <label for="desg">Designation:</label>
        <input type="text" id="desg" name="desg" required><br><br>
        
        <label for="subject">Subject:</label>
        <input type="text" id="subject" name="subject" required><br><br>
        
        <label for="qualification">Qualification:</label>
        <input type="text" id="qualification" name="qualification" required><br><br>
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>
