package uz.pdp.store_online.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    private int id = genId ++;
    private String name;
    private double price;
    private String image;
    private static Integer genId = 1;
}
