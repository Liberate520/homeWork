package tree.human;

import tree.geneticTree.GroupItem;

import java.util.Comparator;

public class HumanComparatorByAge<T extends GroupItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthDate().getYear() - o2.getBirthDate().getYear();
    }
}

