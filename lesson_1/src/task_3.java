
// Дан массив nums = [3,2,2,3] и число val = 3. 
// Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива. 
// Таким образом, первые несколько (или все) элементов массива 
// должны быть отличны от заданного, а остальные - равны ему.
import java.util.Arrays;
import java.util.stream.IntStream;

public class task_3 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = { 3, 2, 2, 3, 2, 3 };
        int nums_len = nums.length;
        int index = 3;

        int[] without = IntStream.range(0, nums_len)
                .filter(i -> nums[i] != index)
                .map(i -> nums[i]).toArray();
        int without_len = without.length;

        int[] with = IntStream.range(0, nums_len)
                .filter(i -> nums[i] == index)
                .map(i -> nums[i]).toArray();
        int with_len = with.length;

        int[] result = new int[without_len + with_len];
        System.arraycopy(without, 0, result, 0, without_len);
        System.arraycopy(with, 0, result, without_len, with_len);
        System.out.println(Arrays.toString(result));
    }
}
