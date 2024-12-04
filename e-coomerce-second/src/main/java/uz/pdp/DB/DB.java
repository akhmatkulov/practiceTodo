package uz.pdp.DB;

import uz.pdp.entity.Category;
import uz.pdp.entity.Product;
import uz.pdp.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DB {
    List<User> USERS = new ArrayList<>(List.of(
            new User("akmal", "3333", "3333", "user"),
            new User("bahrom", "4444", "4444", "user"),
            new User("admin", "1111", "1111", "admin")
    ));

    List<Category> CATEGORIES = new ArrayList<>(List.of(
            new Category("Books"),
            new Category("Drinks"),
            new Category("Clothes")
    ));

    List<Product> products = new ArrayList<>(List.of(
            new Product("Good To Great", 3.5, 1, "goodToGreat.jpg"),
            new Product("Retire Inspired", 4.5, 1, "retire Inspired.jpg"),
            new Product("Small Business Big Money", 7.5, 1, "smallBusinessBigMoney.jpg"),
            new Product("Start Your Own Business", 5.5, 1, "StartyourOwnBusiness.jpg"),
            new Product("Cappuccino", 7, 2, "cappuccino.jpg"),
            new Product("Green Tea", 2, 2, "tea.jpg"),
            new Product("Prime Energy Drink", 5, 2, "prime.jpg"),
            new Product("Iced Coffee Latte", 12, 2, "icedCoffee.jpg"),
            new Product("HUDI", 50, 3, "hudi.jpg"),
            new Product("Jeans", 40, 3, "jeans.jpg"),
            new Product("T-shirt", 30, 3, "t-shirt.jpg"),
            new Product("Sneakers", 150, 3, "sneakers.jpg")
    ));

    static Product getProductById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    Map<Product, Integer> map = new HashMap<>();

}
