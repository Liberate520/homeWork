import java.util.Arrays;

public class Sorter {
    public  void sortByLastDigit(Integer[] array)
    {
        Arrays.sort(array, new ComparatorByLastDigit());
    }
}
