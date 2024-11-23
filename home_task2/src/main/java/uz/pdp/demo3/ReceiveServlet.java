package uz.pdp.demo3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/receive")
public class ReceiveServlet extends HttpServlet {

    private List<String> textList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");

        if (text != null && !text.isEmpty()) {
            textList.add(text);
        }
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.printf("""
         
                <!doctype html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport"
                          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
                    <meta http-equiv="X-UA-Compatible" content="ie=edge">
                    <title>Receive</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
                     <style>
                                    .box {
                                        height: 500px;
                                        border: 1px solid;
                                        margin-top: 50px;
                                        margin-right: 20px;
                                        margin-left: 20px;
                                        display: flex;
                                        flex-direction: column;
                                        align-items: center;
                                        padding-top: 50px;
                                    }
                                    .btn-custom {
                                        width: auto;
                                        background-color: #6c63ff;
                                        border: black;
                                        color: white;
                                        font-weight: bold;
                                        border-radius: 5px;
                                        margin-left: 20px;
                                    }
                                    .btn-custom:hover {
                                        background-color: #574bce;
                                    }
                                </style>
                </head>
                <body>
                <div class="row">
                    <div class="col-6">
                        <div class="box">
                """, text);

        for (String savedText : textList) {
            writer.printf("<p><strong>%s</strong></p>", savedText);
        }

        writer.println("""
                            <form action="/send">
                                <button type="submit" class="btn btn-custom">Back</button>
                            </form>
                        </div>
                    </div>
                </div>
                </body>
                </html>
                """);
    }
}
