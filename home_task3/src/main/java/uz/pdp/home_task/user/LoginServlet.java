package uz.pdp.home_task.user;

import uz.pdp.home_task.db.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    public static User currentUser;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String phoneNumber = req.getParameter("phoneNumber");
        String password = req.getParameter("password");

        Optional<User> userOptional = DB.USERS.stream()
                .filter(user -> user.getPhoneNumber().equals(phoneNumber) && user.getPassword().equals(password))
                .findFirst();

        if (userOptional.isPresent()) {
            currentUser = userOptional.get();
            resp.sendRedirect("/country");
        } else {
            resp.setContentType("text/html");
            resp.getWriter().println("""
                    <html>
                    <body style="text-align:center; margin-top:50px;">
                    <h2 style="color:red;">Invalid phone number or password!</h2>
                    <a href="/login" style="color:blue;">Try Again</a>
                    </body>
                    </html>
                    """);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("""
                <!doctype html>
                <html lang="en">
                <head>
                  <meta charset="UTF-8">
                  <meta name="viewport" content="width=device-width, initial-scale=1.0">
                  <meta http-equiv="X-UA-Compatible" content="ie=edge">
                  <title>Login</title>
                  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
                  <style>
                    body {
                      background: linear-gradient(135deg, #74ebd5, #ACB6E5);
                      height: 100vh;
                      display: flex;
                      justify-content: center;
                      align-items: center;
                      font-family: 'Arial', sans-serif;
                    }
                    .login-container {
                      background: #fff;
                      padding: 30px;
                      border-radius: 15px;
                      box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
                      width: 100%;
                      max-width: 400px;
                    }
                    .login-container .btn-primary {
                      background: #6c63ff;
                      border: none;
                      transition: background 0.3s;
                    }
                    .login-container .btn-primary:hover {
                      background: #4b48c9;
                    }
                    .login-container h2 {
                      margin-bottom: 20px;
                      font-weight: bold;
                      color: #333;
                    }
                    .form-floating label {
                      font-size: 0.9rem;
                    }
                  </style>
                </head>
                <body>
                <div class="login-container">
                  <h2 class="text-center">Login</h2>
                  <form method="post" action="/login">
                    <div class="form-floating mb-3">
                      <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" placeholder="Phone Number" required>
                      <label for="phoneNumber">Phone</label>
                    </div>
                    <div class="form-floating mb-3">
                      <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
                      <label for="password">Password</label>
                    </div>
                    <div class="d-grid">
                      <button type="submit" class="btn btn-primary">Login</button>
                    </div>
                    <div class="text-center mt-3">
                      <small>Don't have an account? <a href="#" class="text-primary">Sign Up</a></small>
                    </div>
                  </form>
                </div>
                </body>
                </html>
                """);
    }
}
