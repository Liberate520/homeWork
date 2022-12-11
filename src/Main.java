import java.util.Arrays;

// Создать метод, который принимает массив int и сортирует его по последней цифре. Используйте метод Arrays.sort.
// для его работы создайте свой компаратор. Имеется в виду последняя цифра в записи числа, например в числе 123,
// последння цифра 3. Надо сделать сортировку, которая учитывает только эту последнюю цифру в числе.

// Создайте класс, который представляет из себя коллекцию, добавьте 2 метода add и get для работы с коллекцией.
// Реализуйте возможность использования цикла for-each для работы с данной коллекцией.
// Для этого реализуйте интерфейс Iterable и создайте итератор

public class Main {
    public static void main(String[] args) {
        IntArray arrayint = new IntArray(30);

        arrayint.fill();
        System.out.println("Origin Array: ");
        System.out.println(arrayint);


        Arrays.sort(arrayint.getArray(), new CompareByLastNum());
        System.out.println("Sorted Array: ");
        System.out.println(arrayint);

        Coll collection = new Coll();
        collection.addArray(5);
        collection.addArray(10);
        collection.addArray(15);
        collection.addArray(12);
        System.out.println("Вывод каждого элемента: ");
        int count = 1;
        for (IntArray intarray: collection
             ) {
            System.out.println("Element #" + count++);
            System.out.println(intarray);
        }

        //
        System.out.println("Вывод конкретного элемента: ");
        System.out.println(collection.getArray(3));
    }

}