package comparators;

import java.util.Comparator;
import main.Human;

public class ComparatorByName<T extends Human> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return CharSequence.compare(o1.getLastname(), o2.getLastname());
    }
}