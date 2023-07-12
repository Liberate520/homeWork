package genTree.comparators;

import java.util.Comparator;
import interfaces.GenTreeItem;

public class ByFullName<T extends GenTreeItem<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getFullName().compareTo(o2.getFullName());
    }
}