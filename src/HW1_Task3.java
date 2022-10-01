
public class HW1_Task3 {

    static void printArray(int[]array){
        for (int i : array) {
            System.out.print(i + "  ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,2,2,3};
        int val = 3;
        System.out.print("Изначальный массив: ");
        printArray(arr);
        System.out.println(" ");
        int j = 0;
        for (int i : arr) {
            if (arr[i] == val) {
                continue;
            }
            else {
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
                j++;
            }
        }
        System.out.print("Массив после перемещения "+val+" в конец: ");
        printArray(arr);


    }
}
