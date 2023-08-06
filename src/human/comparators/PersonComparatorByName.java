package human.comparators;

import tree.TreeItem;

import java.util.Comparator;

public class PersonComparatorByName<T extends TreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
