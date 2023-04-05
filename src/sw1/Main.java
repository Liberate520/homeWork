package sw1;

//    @Liberate520
// мой тг
public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        Bottle bottle = new Bottle(100, "Sprite", 2);
        System.out.println(bottle);
    }
}
