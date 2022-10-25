package lesson4;

import java.util.LinkedList;

public class home3 {
    // Найдите сумму всех элементов LinkedList, сохраняя все элементы в списке. Используйте итератор
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        System.out.println(list);
        System.out.println("Sum: " + sum);
    }
}
