package uz.pdp.cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        StringBuilder s= new StringBuilder();
        for (Cookie cookie : cookies) {
            s.append(cookie.getName()).append("=").append(cookie.getValue()).append("\n");
        }
        resp.setContentType("text/html");
        resp.getWriter().println("<h1> Hello World : "+ s +" </h1>");
    }
}
