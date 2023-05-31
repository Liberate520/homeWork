import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
   private int capacity;
   private List<Product> productList;

   public VendingMachine(){
      productList = new ArrayList<>();
      capacity = 100;

   }
   public void addProduct(Product product){
      if(productList.size() < capacity){
         productList.add(product);
      }
   }
   public  Product findProductByName(String name){
      for (Product product: productList){
         if(product.getName().equalsIgnoreCase(name)){
            return  product;
         }
      }
      return null;
   }
   public  String getProductList(){
      StringBuilder stringBuilder = new StringBuilder();
      for (Product product: productList){
         stringBuilder.append(product);
         stringBuilder.append("\n");
      }
      return  stringBuilder.toString();
   }
}
