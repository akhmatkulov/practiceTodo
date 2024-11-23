package uz.pdp.practicetodo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

@WebServlet("/todo")
public class ToDoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ToDo> toDos = new ArrayList<>(DB.TODOS);
        String filter = req.getParameter("filter");
        if (filter != null && filter.equals("completed")) {
            toDos = toDos.stream().filter(ToDo::getCompleted).toList();
        } else if (filter != null && filter.equals("in_progress")) {
            toDos = toDos.stream().filter(item -> !item.getCompleted()).toList();
        }
        StringJoiner stringJoiner = new StringJoiner("","<ul>","</ul");
        for (ToDo todo : toDos) {
            stringJoiner.add("""
                    <li style="display:flex; gap:10px; text-decoration:%s;">
                        %s
                        <form action="/todo/remove">
                        <input name="id" type="hidden" value="%d">
                        <button>x</button>
                        </form>
                    </li>
                    """.formatted(todo.getCompleted()?"line-through":"none",todo.getText(),todo.getId()));
        }
        PrintWriter writer = resp.getWriter();
        writer.println("""
                <!doctype html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport"
                          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
                    <meta http-equiv="X-UA-Compatible" content="ie=edge">
                    <title>Todo</title>
                </head>
                <body>
                <form action="/todo">
                <select name="filter">
                <option value="all">All</option>
                <option value="completed">Completed</option>
                <option value="in_progress">Inprogress</option>
                </select>
                <button>ok</button>
                </form>
                <form action="/todo/add">
                    Is active? <input type="checkbox" name="completed">
                    &nbsp;
                    <input autofocus name="text" type="text">
                    <button>ok</button>
                </form>
                    %s
                </body>
                </html>
                """.formatted(stringJoiner.toString()));
    }
}
