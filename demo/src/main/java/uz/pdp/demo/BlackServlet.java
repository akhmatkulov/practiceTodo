package uz.pdp.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/black")
public class BlackServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
                             <style>
                                 body{
                                     background-color: black;
                                 }
                             </style>
                         </head>
                         <body>
                            <a href="/red" style="color: red"> Redga o'tish </a>
                         </body>
                         </html>""");

    }
}
