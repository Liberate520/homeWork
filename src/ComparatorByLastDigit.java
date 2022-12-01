import java.util.Comparator;

public class ComparatorByLastDigit implements Comparator<Integer> {

    @Override
    public int compare(Integer dig1, Integer dig2) {
        return Integer.compare((dig1 % 10), dig2 % 10);
    }
}
