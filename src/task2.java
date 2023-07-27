import java.io.IOException;
import java.util.logging.*;

public class task2 {

    public static void printArrayInt(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.print(arr[arr.length - 1]);
    }

    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(task2.class.getName());
        FileHandler fh = new FileHandler("logtask2.xml");
        logger.addHandler(fh);
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        logger.info("массив");
        int[] array = { 1, 5, 6, 9, -2, 11, 16 };
        printArrayInt(array);
        int[] newArr = listSort(array);
        System.out.printf("\n Отсортированный массив: \n");
        printArrayInt(newArr);

    }

    public static int[] listSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
