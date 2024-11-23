package uz.pdp.store_online.entity;

public class Cart {
    private int id = genId++;
    private Product product;
    private int quantity;
    private User user;
    private static Integer genId = 1;
}
