/*
Создать метод, который принимает массив int и сортирует его по последней цифре.
    Используйте метод Arrays.sort. для его работы создайте свой компаратор.
    Имеется в виду последняя цифра в записи числа, например в числе 123, последння цифра 3.
    Надо сделать сортировку, которая учитывает только эту последнюю цифру в числе.

Создайте класс, который представляет из себя коллекцию, добавьте 2 метода add и get для работы с коллекцией.
    Реализуйте возможность использования цикла for-each для работы с данной коллекцией.
    Для этого реализуйте интерфейс Iterable и создайте итератор
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // Создаём массив
        List<Integer> myArr = new ArrayList<>();
        MySort mySort = new MySort();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            myArr.add(r.nextInt(1000 - 10) + 10);
        }
        System.out.println("NOT sort -> " + myArr);
        //передаём масив в метод
        mySort.lastDigitSort(myArr);
        System.out.println("ITS sort -> " + myArr);
        System.out.println();

        // начало второго задания
        // Создаём класс
        MyCollection myCollection = new MyCollection();
        myCollection.add("a = " + r.nextInt(1000));
        myCollection.add("b = " + r.nextInt(1000));
        myCollection.add("c = " + r.nextInt(1000));
        myCollection.add("d = " + r.nextInt(1000));
        myCollection.add("e = " + r.nextInt(1000));

        System.out.println("Its collection " + myCollection.get());

        for (Object item: myCollection) {
            System.out.println(item);
        }
        System.out.println();

        // пробуем со своим классом
        MyCollection myCollTest = new MyCollection();
        myCollTest.add(new TestClass());
        myCollTest.add(new TestClass());
        myCollTest.add(new TestClass());
        myCollTest.add(new TestClass());
        myCollTest.add(new TestClass());

        for (Object item: myCollTest) {
            System.out.println(item);
        }

    }
}
