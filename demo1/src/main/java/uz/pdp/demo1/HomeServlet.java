package uz.pdp.demo1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Counter.count++;
        PrintWriter writer = resp.getWriter();
        writer.println("""
                <!doctype html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport"
                          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
                    <meta http-equiv="X-UA-Compatible" content="ie=edge">
                    <title>Document</title>
                </head>
                <body>
                <h1>
                    %d
                </h1>
                <a href="/home?name=Eshmatjon">
                    <button>+</button>
                    </a>
                <a href="/home?name=Toshmatjon">
                    <button>-</button>
                    </a>
                </body>
                </html>
                """.formatted(Counter.count));
    }
}
