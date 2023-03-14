package sorted;

import java.util.Comparator;
import genealogicalTree.*;

public class ComparatorByYear<T extends Human> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o2.getBirthDate(), o1.getBirthDate());
    }
}
