import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Student")
public class Student extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve student details from the request parameters
        int seatNo = Integer.parseInt(request.getParameter("seatNo"));
        String studName = request.getParameter("studName");
        String studentClass = request.getParameter("studentClass");
        int totalMarks = Integer.parseInt(request.getParameter("totalMarks"));

        // Calculate percentage
        double percentage = (totalMarks / 500.0) * 100;

        // Calculate grade based on percentage
        String grade;
        if (percentage >= 90) {
            grade = "A+";
        } else if (percentage >= 80) {
            grade = "A";
        } else if (percentage >= 70) {
            grade = "B";
        } else if (percentage >= 60) {
            grade = "C";
        } else if (percentage >= 50) {
            grade = "D";
        } else {
            grade = "Fail";
        }

        // Display student details and result
        out.println("<html><head><title>Student Details</title></head><body>");
        out.println("<h1>Student Details</h1>");
        out.println("<p>Seat No: " + seatNo + "</p>");
        out.println("<p>Name: " + studName + "</p>");
        out.println("<p>Class: " + studentClass + "</p>");
        out.println("<p>Total Marks: " + totalMarks + "</p>");
        out.println("<p>Percentage: " + percentage + "%</p>");
        out.println("<p>Grade: " + grade + "</p>");
        out.println("</body></html>");
    }
}

