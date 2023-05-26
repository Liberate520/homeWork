package com.example.VendingMachine;

public class Product {
    private static int global_id;
    private int id;
    private String name;
    private double price;

    public Product(String name, double price) {
        id = global_id++;
        this.name = name;
        this.price = price;
    }

    public Product() {
        this("default", -1);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price;
    }
}
