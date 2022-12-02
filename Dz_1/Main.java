

//Создать метод, который принимает массив int и сортирует его по последней цифре.
//Используйте метод Arrays.sort. для его работы создайте свой компаратор.
//Имеется в виду последняя цифра в записи числа, например в числе 123, последння цифра 3.
//Надо сделать сортировку, которая учитывает только эту последнюю цифру в числе.


import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[] {64, 12, 123, 65, 35, 99, 236, 8, 121};
        System.out.println("Заданый массив: " + Arrays.toString(array));

        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1%10) - (o2%10);
            }
        });
        System.out.println("Отсортированный: " + Arrays.toString(array));
       }
    }