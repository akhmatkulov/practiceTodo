package uz.pdp.store_online.DataBase;

import uz.pdp.store_online.entity.Product;

import java.util.ArrayList;
import java.util.List;

public interface DB {

     List<Product> products = new ArrayList<>();
     List<Category> categories = new ArrayList<>();
}
