import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] array = {123, 964,34, 986,41, 480};
        new Sorter().sortByLastDigit(array);
        System.out.println(Arrays.toString(array));
    }
}
