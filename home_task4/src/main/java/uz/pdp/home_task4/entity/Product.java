package uz.pdp.home_task4.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Integer id = idGen ++;
    private String name;
    private double price;
    private Integer categoryId;
    private static Integer idGen = 1;

    public Product(String name, double price, Integer categoryId) {
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }
}