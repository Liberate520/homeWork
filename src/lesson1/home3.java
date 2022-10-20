package lesson1;
import java.util.Arrays;

public class home3 {
    // Дан массив nums = [3,2,2,3] и число val = 3. Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива. 
    // Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.

    public static void reorder(int[] nums, int val)
    {
        int k = 0;
        for (int i: nums)
        {
            if (i != val) {
                nums[k++] = i;
            }
        }
        for (int i = k; i < nums.length; i++) {
            nums[i] = val;
        }
    }

    public static void main(String[] args) {
        int val = 3;
        int[] nums;
        nums = new int[] { 3,2,2,3,5,6,3,2,5 };
        reorder(nums,val);
        System.out.println(Arrays.toString(nums));					
    }   
}
