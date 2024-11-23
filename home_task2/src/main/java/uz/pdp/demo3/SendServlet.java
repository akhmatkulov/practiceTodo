package uz.pdp.demo3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/send")
public class SendServlet extends HttpServlet {
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
                    <title>Send</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
                     <style>
                            .box {
                                height: 500px;
                                border: 1px solid;
                                margin-right: 20px;
                                margin-left: 20px;
                                margin-top: 50px;
                                display: flex;
                                align-items: center;
                                flex-direction: column;
                                padding-top: 50px;
                            }
                
                            .input-box {
                                width: auto;
                                margin-bottom: 20px;
                            }
                
                            .btn-custom {
                                width: auto;
                                background-color: #6c63ff;
                                border: none;
                                color: white;
                                font-weight: bold;
                                border-radius: 5px;
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
                            <form action="/receive">
                            <input type="text" class="form-control input-box" placeholder="Enter your text here" name="text">
                                <button type="submit" class="btn btn-custom">Send</button>
                            </form>
                        </div>
                    </div>
                </div>
                </body>
                </html>""");
    }
}