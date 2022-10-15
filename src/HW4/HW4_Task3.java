package HW4;

import java.util.Iterator;
import java.util.LinkedList;

public class HW4_Task3 {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList();
        LinkedList<Integer> list2 = new LinkedList();

        for (int i = 1; i <= 10; i++) {
            list1.add(i);
        }
        for (int i = 1; i <= 10; i++) {
            list2.add(1);
        }
        System.out.println("list1:" + list1);
        System.out.println("list2:" + list2);

        Iterator<Integer> iterator1 = list1.iterator();
        Iterator<Integer> iterator2 = list2.iterator();
        int sum = 0;

        while (iterator1.hasNext()){
            int temp = iterator1.next();
            sum+= temp;
        }
        System.out.println("Сумма списка list1: " + sum);
        sum = 0;
        while (iterator2.hasNext()){
            int temp = iterator2.next();
            sum+= temp;
        }

        System.out.println("Сумма списка list2: " + sum);

    }
}
