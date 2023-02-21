package src.comparator;

import src.Human;
import src.It;

import java.util.Comparator;

public class HumanComparatorByAge<T extends It> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
