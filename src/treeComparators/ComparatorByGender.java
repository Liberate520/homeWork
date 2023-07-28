package treeComparators;

import enums.Gender;
import treeWorkspace.TreeItem;

import java.util.Comparator;

public class ComparatorByGender<E extends TreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E p1, E p2) {
        if (p1.getGender().equals(p2.getGender())) {
            return 0;
        } else if (p1.getGender().equals(Gender.Male)
                && p2.getGender().equals(Gender.Female)) {
            return 1;
        }
        return -1;
    }
}
