// Дан массив двоичных чисел, например [1,1,0,1,1,1], 
// вывести максимальное количество подряд идущих 1
/**
 * task_2
 */
public class task_2 {
    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0 };
        int result = 0;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            } else {
                if (result < count) {
                    result = count;
                }
                count = 0;
            }
        }
        System.out.println(result);
    }
}