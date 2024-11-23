package uz.pdp.home_task4.servlets;

import uz.pdp.home_task4.DB;
import uz.pdp.home_task4.entity.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet("/addProduct")
@MultipartConfig // Fayllar yuklash uchun zarur
public class AddProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String priceStr = req.getParameter("price");
        String categoryIdStr = req.getParameter("category");
        Part imagePart = req.getPart("image");

        // Double va Integer qiymatlarni parsing qilish
        double price = Double.parseDouble(priceStr);
        int categoryId = Integer.parseInt(categoryIdStr);

        // Fayl nomini olish (bu faylni saqlash uchun ishlatilishi mumkin)
        String fileName = imagePart.getSubmittedFileName();

        // Mahsulotni DBga qo'shish
        Product newProduct = new Product(name, price, categoryId);
        DB.PRODUCTS.add(newProduct);


        System.out.println("Products --> " + DB.PRODUCTS);

        // Javobni muvaffaqiyatli qilish
        resp.sendRedirect("/addProduct.jsp");
    }
}

