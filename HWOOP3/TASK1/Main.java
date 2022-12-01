package TASK1;

import java.util.Arrays;
import java.util.Comparator;

/**
 Создать метод, который принимает массив int и сортирует его по последней цифре.
 Используйте метод Arrays.sort. для его работы создайте свой компаратор.
 Имеется в виду последняя цифра в записи числа, например в числе 123, последння цифра 3.
 Надо сделать сортировку, которая учитывает только эту последнюю цифру в числе.
 */
public class Main {
    public static void main(String[] args) {
    sorting();
    }

    public static void sorting(){
        Integer[] array = new Integer[] {100, 4, 661, 723, 456, 123, 921, 23140, 122};
        Arrays.sort(array, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 % 10) - (o2 % 10);
            }
        });
        System.out.println(Arrays.toString(array));
    }
}