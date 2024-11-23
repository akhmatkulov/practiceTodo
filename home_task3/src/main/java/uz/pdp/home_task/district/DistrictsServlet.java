package uz.pdp.home_task.district;

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

@WebServlet("/district")
public class DistrictsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String regionIdParam = req.getParameter("regionId");
        String deleteIdParam = req.getParameter("delete");

        if (deleteIdParam != null && regionIdParam != null) {
            int deleteId = Integer.parseInt(deleteIdParam);
            DB.DISTRICT.removeIf(district -> district.getId() == deleteId);
            resp.sendRedirect("/district?regionId=" + regionIdParam);
            return;
        }

        if (regionIdParam == null) {
            resp.sendRedirect("/region");
            return;
        }

        int regionId = Integer.parseInt(regionIdParam);

        List<Districts> districts = DB.DISTRICT.stream()
                .filter(district -> district.getRegionId() == regionId)
                .collect(Collectors.toList());

        PrintWriter writer = resp.getWriter();
        writer.println("""
               <!doctype html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <meta http-equiv="X-UA-Compatible" content="ie=edge">
                    <title>Districts List</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
                </head>
                <body>
                    <div class="container mt-4">
                        <h1>Districts of Region</h1>
                        <!-- Input and Add Button -->
                        <form method="POST">
                            <input type="hidden" name="regionId" value="%s">
                            <div class="mb-3">
                                <input type="text" id="districtInput" name="district" class="form-control" placeholder="Enter district name">
                                <button type="submit" class="btn btn-primary mt-2">Add</button>
                            </div>
                        </form>

                        <table class="table table-bordered" id="districtsTable">
                            <thead>
                                <tr>
                                    <th>District Name</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
               """.formatted(regionIdParam));

        for (Districts district : districts) {
            writer.println("<tr>");
            writer.println("<td>" + district.getName() + "</td>");
            writer.println("<td>");
            writer.println("<a href='/district?regionId=" + regionId + "&delete=" + district.getId() + "' class='btn btn-danger btn-sm'>X</a>");
            writer.println("</td>");
            writer.println("</tr>");
        }

        writer.println("""
                            </tbody>
                        </table>
                        <a href="/region" class="btn btn-secondary mt-3">Back to Regions</a>
                    </div>
                </body>
                </html>
                """);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String regionIdParam = req.getParameter("regionId");
        String districtName = req.getParameter("district");

        if (regionIdParam == null || districtName == null || districtName.isEmpty()) {
            resp.sendRedirect("/region");
            return;
        }

        int regionId = Integer.parseInt(regionIdParam);
        int newId = DB.DISTRICT.size() + 1;

        DB.DISTRICT.add(new Districts(newId, districtName, regionId));


        resp.sendRedirect("/district?regionId=" + regionId);
    }
}
