//Задание2 написан исправленный код

public class Main2 {
    public static void main(String[] args) {

        int[] intArray = {1, 2, 3 , 4};
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException | IndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
