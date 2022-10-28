package lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class home2 {
    // Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка. (Collections.max())
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(12);
        list.add(28);
        list.add(34);
        list.add(56);
        list.add(43);
        list.add(18);
        System.out.println("Max: " + Collections.max(list));
        System.out.println("Min: " + Collections.min(list));
        System.out.println("Average: " + average(list));
    }
    static int average(List<Integer> list) {
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        return sum / (list.size());
    }
    
}
