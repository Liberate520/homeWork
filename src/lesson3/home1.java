package lesson3;

import java.util.ArrayList;
import java.util.List;

public class home1 {
    // Пусть дан произвольный список целых чисел, удалить из него четные числа

    public static void main(String[] args) {
// Declare an empty List of size 5
        List<Integer> list = new ArrayList<Integer>(5);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(1);
        list.add(7);
        list.add(4);
        System.out.println(list);
        System.out.println(delNums(list));
    }

    static List<Integer> delNums(List <Integer> nums) {
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) % 2 == 0) {
                nums.remove(i);
            }
        }
        return nums;
    }
}