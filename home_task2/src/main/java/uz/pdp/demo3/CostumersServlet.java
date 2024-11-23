package uz.pdp.demo3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/costumer")
public class CostumersServlet extends HttpServlet {
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
                    <title>Admin</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
                    <style>
                        .box {
                            margin-left: 20px;
                            margin-right: 20px;
                            margin-top: 20px;
                            border: 1px solid;
                            height: 550px;
                        }
                        .info {
                            margin-right: 20px;
                            margin-left: 20px;
                            margin-top: 20px;
                            border: 1px solid;
                            color: darkblue;
                            text-align: center;
                            padding: 20px;
                            front-size: 100px;
                        }
                    </style>
                </head>
                <body>
                <div class="row">
                    <div class="col-3">
                        <div class="box">
                            <div class="row">
                                <div class="col">
                                    <div class="info">
                                        <a href="/order">
                                            <button type="submit" class="btn btn-custom">Orders</button>
                                        </a>
                                    </div>
                                    <div class="info">
                                       <a href="/product">
                                            <button type="submit" class="btn btn-custom">Products</button>
                                        </a>
                                    </div>
                                    <div class="info">
                                        <a href="/costumer">
                                            <button type="submit" class="btn btn-custom">Costumers</button>
                                        </a>
                                    </div>
                                    <div class="info">
                                        <a href="/profile">
                                            <button type="submit" class="btn btn-custom">Profile</button>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-9">
                        <div class="box">
                            <h1 style=" padding: 50px; display: flex; justify-content: center; align-items: center; color: darkblue">Costumer</h1>
                        </div>
                    </div>
                </div>
                </body>
                </html>
                """);
    }
}
