package ru.gb.vending_machine;
import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private Integer id;
    private Integer productId;
    private List<Product> productList;

    public VendingMachine(Integer id) {
        this.id = id;
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        product.setId(productId++);
        productList.add(product);
    }

    public String getProducts() {
        StringBuilder sb = new StringBuilder();
        sb.append("Список продуктов:\n");
        for (Product product : productList) {
            sb.append(product);
            sb.append("\n");
        }
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }
}
