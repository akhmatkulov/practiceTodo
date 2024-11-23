package uz.pdp.demo3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("""
                <!doctype html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <title>Calculator</title>
                  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
                  <style>
                    .box {
                      border: 1px solid black;
                      height: 200px;
                      margin-top: 50px;
                      padding: 20px;
                      text-align: center;
                    }
                    .input-display {
                      width: 100%;
                      height: 50px;
                      font-size: 25px;
                      text-align: right;
                      margin-bottom: 20px;
                      padding: 10px;
                    }
                    .btn {
                      width: 70px;
                      height: 50px;
                      font-size: 22px;
                    }
                  </style>
                </head>
                <body>
                <div class="container">
                  <div class="row justify-content-center">
                    <div class="col-4">
                      <div class="box">
                        <input type="number" class="input-display" placeholder="0">
                        <div class="row justify-content-center">
                          <div class="col-2"><button class="btn btn-primary">+</button></div>
                          <div class="col-2"><button class="btn btn-primary">-</button></div>
                          <div class="col-2"><button class="btn btn-primary">*</button></div>
                          <div class="col-2"><button class="btn btn-primary">/</button></div>
                          <div class="col-2"><button class="btn btn-success">=</button></div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                </body>
                </html>

                """);
    }
}
