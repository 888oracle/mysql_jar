

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.*;
import java.util.*;

public class Session extends HttpServlet {
   
  public void doGet(HttpServletRequest req, HttpServletResponse res)
                               throws ServletException, IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();

    // Get the current session object, create one if necessary
    HttpSession session = req.getSession();

    out.println("<HTML><HEAD><TITLE>SessionTimer</TITLE></HEAD>");
    out.println("<BODY><H1>Session Timer</H1>");

    // Display the previous timeout
    out.println("The previous timeout was " +
                session.getMaxInactiveInterval());
    out.println("<BR>");

    // Set the new timeout
    session.setMaxInactiveInterval(2*60*60);  // two hours

    // Display the new timeout
    out.println("The newly assigned timeout is " +
                session.getMaxInactiveInterval());

    out.println("</BODY></HTML>");
  }
}

