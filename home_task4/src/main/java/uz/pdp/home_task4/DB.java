package uz.pdp.home_task4;

import uz.pdp.home_task4.entity.Category;
import uz.pdp.home_task4.entity.Product;
import uz.pdp.home_task4.entity.User;

import java.util.ArrayList;
import java.util.List;

public interface DB {

    List<User> USERS = new ArrayList<>(List.of(
       new User("Eshmat","Toshmatov", "+998912345678","1111"),
       new User("Toshmat","Eshmatov", "+998901234567","2222")
    ));

    List<Category> CATEGORIES = new ArrayList<>(List.of(
            new Category("Foods"),
            new Category("Drinks")
    ));

    List<Product> PRODUCTS = new ArrayList<>(List.of(
            new Product("Bread", 3700.00, 1),
            new Product("Flavis", 6000.00, 2)
    ));



}
