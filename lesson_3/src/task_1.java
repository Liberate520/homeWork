import java.util.ArrayList;
import java.util.List;

// Пусть дан произвольный список целых чисел, удалить из него четные числа

public class task_1 {
    public static void main(String[] args) {
        Integer[] inputList = { 2, 3, 5, 1, 5 };
        // System.out.println(delEvenNums(inputList));
    }

    static List<Integer> delEvenNums(Integer[] nums) {
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                resList.add(nums[i]);
            }
        }
        return resList;
    }
}
