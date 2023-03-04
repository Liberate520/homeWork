package src.comparator;

import src.Human;
import src.It;

import java.util.Comparator;

public class HumanComparatorByLastName<T extends It> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getLastName().compareTo(o2.getLastName());
    }
}
