import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RequestInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get client information
        String clientIP = request.getRemoteAddr();
        String clientBrowser = request.getHeader("User-Agent");

        // Get server information
        String serverInfo = getServletContext().getServerInfo();
        String serverOS = System.getProperty("os.name");

        // Get list of loaded servlets
        Enumeration<String> servletNames = getServletContext().getServletNames();
        StringBuilder loadedServlets = new StringBuilder();
        while (servletNames.hasMoreElements()) {
            loadedServlets.append(servletNames.nextElement()).append("<br>");
        }

        // Set response content type
        response.setContentType("text/html;charset=UTF-8");

        // Get print writer to write response
        PrintWriter out = response.getWriter();

        // Write response
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Request Information</title></head>");
        out.println("<body>");
        out.println("<h1>Request Information</h1>");
        out.println("<p>Client IP Address: " + clientIP + "</p>");
        out.println("<p>Client Browser: " + clientBrowser + "</p>");
        out.println("<p>Server Information: " + serverInfo + "</p>");
        out.println("<p>Server Operating System: " + serverOS + "</p>");
        out.println("<p>Loaded Servlets: <br>" + loadedServlets.toString() + "</p>");
        out.println("</body></html>");
    }
}