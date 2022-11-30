import java.util.Comparator;

public class MyComparator implements Comparator<Integer> {

    @Override
    public int compare(Integer t1, Integer t2) {
        return Integer.compare((t1%10),(t2%10));
    }
}
