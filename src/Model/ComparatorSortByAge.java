package Model;

import java.util.Comparator;

public class ComparatorSortByAge<T extends HouseHold> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
