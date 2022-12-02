package OOP.HomeWork_3.Dz_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

// Создайте класс, который представляет из себя коллекцию,
// добавьте 2 метода add и get для работы с коллекцией.
// Реализуйте возможность использования цикла for-each для работы с данной коллекцией.
// Для этого реализуйте интерфейс Iterable и создайте итератор


public class Program {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("======================================");

        for (int i = 0; i < 10; i++) {
            numbers.add(new Random().nextInt(50));
            System.out.print(numbers.get(i) + ", ");
        }

        System.out.println("\n======================================");

        for (Iterator<Integer> iterator = numbers.iterator(); iterator.hasNext();)
        {
            Integer tmp = iterator.next();
            System.out.print(tmp + ", ");
        }

        System.out.println("\n======================================");
    }
}
