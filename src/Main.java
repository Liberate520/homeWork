import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> intArray = new ArrayList<>();
        LastDigitSort lastDigitSort = new LastDigitSort();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            intArray.add(r.nextInt(1000 - 10) + 10);
        }
        System.out.println(intArray);
        lastDigitSort.sort(intArray);
        System.out.println(intArray);
        System.out.println();


        NewCollection newCollection = new NewCollection();
        newCollection.add("a");
        newCollection.add("b");
        newCollection.add("c");
        newCollection.add("d");

        System.out.println(newCollection.get());

        for (Object item: newCollection) {
            System.out.println(item);
        }
    }
}