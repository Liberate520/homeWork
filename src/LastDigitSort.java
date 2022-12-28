import java.util.Comparator;
import java.util.List;

public class LastDigitSort implements Comparator<Integer> {
    public void sort(List<Integer> array) {
        array.sort(new LastDigitSort());
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(o1 % 10, o2 % 10);
    }
}