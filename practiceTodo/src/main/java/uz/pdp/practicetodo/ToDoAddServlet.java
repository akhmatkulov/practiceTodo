package uz.pdp.practicetodo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


@WebServlet("/todo/add")
public class ToDoAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String value = req.getParameter("text");
        String completed = Objects.requireNonNullElse(req.getParameter("completed"),"off");
        DB.TODOS.add(new ToDo(value,completed.equals("on")));
        resp.sendRedirect("/todo");
    }
}
