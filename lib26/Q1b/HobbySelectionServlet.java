import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HobbySelectionServlet")
public class HobbySelectionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get selected hobby from the request parameter
        String hobby = request.getParameter("hobby");

        // Check if a cookie with the hobby already exists
        boolean cookieExists = false;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("hobby")) {
                    cookieExists = true;
                    break;
                }
            }
        }

        // If the cookie does not exist, create a new one and add it to the response
        if (!cookieExists && hobby != null) {
            Cookie hobbyCookie = new Cookie("hobby", hobby);
            hobbyCookie.setMaxAge(60 * 60 * 24 * 365); // Set cookie expiry time (1 year)
            response.addCookie(hobbyCookie);
        }

        // Redirect back to the HTML page
        response.sendRedirect("hobby_selection.html");
    }
}
