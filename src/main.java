import javax.swing.text.Style;

public class main {
    public static void main(String[] args) {
        Product twix = new Product("twix", 100); // Создали обект class продукт
        Product twix2 = new Product("twix2", 150);
        System.out.println(twix.getPrice());
        System.out.println(twix.getName());
        System.out.println(twix);
        System.out.println(twix2);

    }
}
