package uz.pdp.home_task.region;

import uz.pdp.home_task.db.DB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/region")
public class RegionsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String countryIdParam = req.getParameter("countryId");
        String deleteIdParam = req.getParameter("delete");

        if (deleteIdParam != null && countryIdParam != null) {
            int deleteId = Integer.parseInt(deleteIdParam);
            DB.REGION.removeIf(region -> region.getId() == deleteId);
            resp.sendRedirect("/region?countryId=" + countryIdParam);
            return;
        }

        if (countryIdParam == null) {
            resp.sendRedirect("/country");
            return;
        }

        int countryId = Integer.parseInt(countryIdParam);

        List<Regions> regions = DB.REGION.stream()
                .filter(region -> region.getCountryId() == countryId)
                .collect(Collectors.toList());

        PrintWriter writer = resp.getWriter();
        writer.println("""
               <!doctype html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <meta http-equiv="X-UA-Compatible" content="ie=edge">
                    <title>Regions List</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
                </head>
                <body>
                    <div class="container mt-4">
                        <h1>Regions of Country</h1>

                        <form method="POST">
                            <input type="hidden" name="countryId" value="%s">
                            <div class="mb-3">
                                <input type="text" id="regionInput" name="region" class="form-control" placeholder="Enter region name">
                                <button type="submit" class="btn btn-primary mt-2">Add</button>
                            </div>
                        </form>

                        <table class="table table-bordered" id="regionsTable">
                            <thead>
                                <tr>
                                    <th>Region Name</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
               """.formatted(countryIdParam));


        for (Regions region : regions) {
            writer.println("<tr>");
            writer.println("<td>" + region.getName() + "</td>");
            writer.println("<td>");
            writer.println("<a href='/region?countryId=" + countryId + "&delete=" + region.getId() + "' class='btn btn-danger btn-sm'>X</a> ");
            writer.println("<a href='/district?regionId=" + region.getId() + "' class='btn btn-primary btn-sm'>Go</a>");
            writer.println("</td>");
            writer.println("</tr>");
        }

        writer.println("""
                            </tbody>
                        </table>
                        <a href="/country" class="btn btn-secondary mt-3">Back to Countries</a>
                    </div>
                </body>
                </html>
                """);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String countryIdParam = req.getParameter("countryId");
        String regionName = req.getParameter("region");

        if (countryIdParam == null || regionName == null || regionName.isEmpty()) {
            resp.sendRedirect("/country");
            return;
        }

        int countryId = Integer.parseInt(countryIdParam);
        int newId = DB.REGION.size() + 1;


        DB.REGION.add(new Regions(newId, regionName, countryId));


        resp.sendRedirect("/region?countryId=" + countryId);
    }
}
