package uz.pdp.home_task.country;

import uz.pdp.home_task.db.DB;
import uz.pdp.home_task.user.LoginServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/country")
public class CountriesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String deleteId = req.getParameter("delete");
        if (deleteId != null) {
            int id = Integer.parseInt(deleteId);
            DB.COUNTRY.removeIf(country -> country.getId() == id);
            resp.sendRedirect("/country");
            return;
        }

        resp.setContentType("text/html");
        if (LoginServlet.currentUser != null) {
            resp.getWriter().println("<h1>Welcome, " + LoginServlet.currentUser.getFirstName() + "!</h1>");
        } else {
            resp.sendRedirect("/login");
        }

        PrintWriter writer = resp.getWriter();
        writer.println("""
               <!doctype html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <meta http-equiv="X-UA-Compatible" content="ie=edge">
                    <title>Countries List</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
                </head>
                <body>
                    <div class="container mt-4">
                        <h1>List of Countries</h1>
                        <!-- Input and Add Button -->
                        <form method="POST">
                            <div class="mb-3">
                                <input type="text" id="countryInput" name="country" class="form-control" placeholder="Enter country name">
                                <button type="submit" class="btn btn-primary mt-2">Add</button>
                            </div>
                        </form>

                        <table class="table table-bordered" id="countriesTable">
                            <thead>
                                <tr>
                                    <th>Country Name</th>
                                </tr>
                            </thead>
                            <tbody>
               """);

        for (Countries country : DB.COUNTRY) {
            writer.println("<tr>");
            writer.println("<td>" + country.getName() + "</td>");
            writer.println("<td>");
            writer.println("<a href='/country?delete=" + country.getId() + "' class='btn btn-danger btn-sm'>X</a> ");
            writer.println("<a href='/region?countryId=" + country.getId() + "' class='btn btn-primary btn-sm'>Go</a>");
            writer.println("</td>");
            writer.println("</tr>");
        }

        writer.println("""
                            </tbody>
                        </table>
                    </div>
                </body>
                </html>
                """);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String countryName = req.getParameter("country");

        if (countryName != null && !countryName.isEmpty()) {
            int newId = DB.COUNTRY.size() + 1;
            DB.COUNTRY.add(new Countries(newId, countryName));
        }
        resp.sendRedirect("/country");
    }
}
