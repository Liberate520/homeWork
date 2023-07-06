package tree.model.human;

import tree.model.geneticTree.GroupItem;

import java.util.Comparator;

public class HumanComparatorByName<T extends GroupItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }

}
