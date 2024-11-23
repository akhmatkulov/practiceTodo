package uz.pdp.home_task4.servlets;

import uz.pdp.home_task4.DB;
import uz.pdp.home_task4.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/addCategory")
public class AddCategoryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        System.out.println(name);
        DB.CATEGORIES.add(new Category(name));

       req.getSession().setAttribute("category", DB.CATEGORIES);
        resp.sendRedirect("/addCategory.jsp");
    }
}
