
import java.util.Comparator;

public class TComparatorByDate<T extends LiveBeing> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getDate(), o2.getDate());
    }
}
