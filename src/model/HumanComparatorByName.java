package model;

import java.util.Comparator;

public class HumanComparatorByName<T extends TreeGroupItem> implements Comparator<T> {
    public int compare(T o1, T o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
