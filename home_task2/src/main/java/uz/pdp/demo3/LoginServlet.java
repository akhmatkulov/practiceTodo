package uz.pdp.demo3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Modern Login Page</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
                    <style>
                        body, html {
                            height: 100%;
                            margin: 0;
                            font-family: Arial, sans-serif;
                            background: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)), url('https://source.unsplash.com/random/1920x1080') no-repeat center center;
                            background-size: cover;
                        }
                        .login-container {
                            display: flex;
                            justify-content: center;
                            align-items: center;
                            height: 100vh;
                        }
                        .login-card {
                            background: rgba(255, 255, 255, 0.9);
                            padding: 40px;
                            width: 100%;
                            max-width: 400px;
                            border-radius: 10px;
                            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.3);
                        }
                        .login-card h3 {
                            font-weight: 700;
                            color: #333;
                            text-align: center;
                            margin-bottom: 20px;
                        }
                        .form-control {
                            border-radius: 30px;
                            padding: 12px 20px;
                        }
                        .btn-custom {
                            border-radius: 30px;
                            padding: 10px 20px;
                            background-color: #6c63ff;
                            border: none;
                            color: white;
                            font-weight: bold;
                            width: 100%;
                        }
                        .btn-custom:hover {
                            background-color: #574bce;
                        }
                        .forgot-password {
                            text-align: center;
                            display: block;
                            margin-top: 15px;
                            color: #6c63ff;
                            font-size: 14px;
                        }
                        .forgot-password:hover {
                            color: #574bce;
                            text-decoration: underline;
                        }
                    </style>
                </head>
                <body>
                <div class="login-container">
                    <div class="login-card">
                        <h3>Login</h3>
                        
                            <div class="mb-3">
                                <input type="email" class="form-control" placeholder="Email Address" required>
                            </div>
                            <div class="mb-3">
                                <input type="password" class="form-control" placeholder="Password" required>
                            </div>
                            <a href="#" class="forgot-password">Forgot Password?</a>
                        
                        <a href="/admin">
                        <button type="submit" class="btn btn-custom">Log In</button>
                        </a>
                    </div>
                </div>
                </body>
                </html>
                """);
    }
}
