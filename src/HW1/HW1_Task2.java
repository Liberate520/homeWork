package HW1;

public class HW1_Task2 {

    public static void main(String[] args) {
        int[] arr = {1,0,0,1,1,1,1,0,1,1,0,1};
        int oneCurrentValue = 0;
        int oneMaxValue = 0;

        for (int j : arr) {
            if (j == 1) {
                oneCurrentValue++;
            } else {
                oneCurrentValue = 0;
            }
            oneMaxValue = Math.max(oneMaxValue, oneCurrentValue);
        }
        System.out.println("Длина максимальной последовательности единиц в массиве: " + oneMaxValue);
    }
}
