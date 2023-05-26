package com.example.VendingMachine;

public class Main {
    public static void main(String[] args) {
        Product prod1 = new Product("twix1", 100);
        Product prod2 = new Product("twix2", 110);
        Product prod3 = new Bottle("coca-cola", 110, 0.35);
        //System.out.println(prod1);

        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addProduct(prod1);
        vendingMachine.addProduct(prod2);
        vendingMachine.addProduct(prod3);
        vendingMachine.addProduct(new Product("twix3", 150));

        System.out.println(vendingMachine.findProductByName("twix1")+"\n");
        System.out.println(vendingMachine.getProductList());
    }
}
