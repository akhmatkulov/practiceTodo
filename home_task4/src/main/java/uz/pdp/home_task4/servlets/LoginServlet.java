package uz.pdp.home_task4.servlets;

import uz.pdp.home_task4.DB;
import uz.pdp.home_task4.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public static User currentUser = null;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        if (phone != null && password != null) {
            Optional<User> userOptional = DB.USERS.stream().filter(item -> item.getPhone().equals(phone) && item.getPassword().equals(password)).findFirst();
            if (userOptional.isPresent()) {
                currentUser = userOptional.get();
                resp.sendRedirect("/category.jsp");
            } else if (phone.equals("+998977777777") && password.equals("123")) {
                resp.sendRedirect("/adminCategory.jsp");
            } else {
                resp.sendRedirect("/login.jsp");
            }
        } else {
            resp.sendRedirect("/login.jsp");
        }
    }
}
