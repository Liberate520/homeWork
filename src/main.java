import javax.swing.text.Style;

public class main {
    public static void main(String[] args) {
        Product twix = new Product("twix", 100); // Создали обект class продукт
        Product twix2 = new Product("twix2", 150);
        Product cocaCola = new Bottle("coca-cola", 80, 0.7);

        System.out.println(twix.getPrice());
        System.out.println(twix.getName());
        System.out.println(twix);
        System.out.println(twix2);

        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addProduct(twix);
        vendingMachine.addProduct(twix2);
        vendingMachine.addProduct(cocaCola);
        vendingMachine.addProduct(new Product("coca-cola2",80 ));


        Product findProduct = vendingMachine.findProductByName("twix");
        System.out.println(findProduct);

        System.out.println();
        System.out.println(vendingMachine.getProductList());

    }
}
