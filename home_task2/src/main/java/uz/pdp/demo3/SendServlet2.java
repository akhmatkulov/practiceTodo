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

@WebServlet(value ="/send")
public class SendServlet2 extends HttpServlet {

    private static final List<String> messages = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");

        if (text != null && !text.trim().isEmpty()) {
            messages.add(text.trim());
        }

        resp.setContentType("text/html");
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
                      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
                      <style>
                        .box {
                          border: 1px solid;
                          height: 600px;
                          margin-top: 30px;
                          margin-left: 30px;
                          margin-right: 30px;
                          padding: 20px;
                          display: flex;
                          flex-direction: column;
                          align-items: flex-start;
                          justify-content: flex-start;
                        }
                        .input-group {
                          display: flex;
                          align-items: center;
                          gap: 10px;
                        }
                        .box input[type="text"] {
                          width: 100%;
                          max-width: 300px;
                        }
                        .box button {
                          background-color: #6c63ff;
                          color: white;
                          border: none;
                          padding: 8px 16px;
                          border-radius: 2px;
                        }
                        .box button:hover {
                          background-color: #574bce;
                        }
                      </style>
                    </head>
                    <body>
                    <div class="row">
                      <div class="col-5">
                        <div class="box">
                          <div class="input-group">
                            <form action="/send">
                            <input type="text" class="form-control" placeholder="Enter text here" name="text">
                            <button type="submit" class="btn btn-custom">OK</button>
                            </form>
                          </div>
                     <div class="message-list">
                    """);
                             for (String message : messages) {
                                 writer.printf("<div class='message-item'>%s</div>", message);
                             }

        writer.println("""
                      </div>
                    </div>
                  </div>
                </div>
                </body>
                </html>
                """);
    }
}
