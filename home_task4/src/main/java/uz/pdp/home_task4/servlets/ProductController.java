package uz.pdp.home_task4.servlets;

import uz.pdp.home_task4.DB;
import uz.pdp.home_task4.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/product")
public class ProductController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String parameter = req.getParameter("id");
        int id = Integer.parseInt(parameter);
        List<Product> list = DB.PRODUCTS.stream().filter(p -> p.getCategoryId() == id).toList();
        resp.getWriter().print(list);
    }
}
