package comparators;

import tree.FamilyTreeItem;

import java.util.Comparator;

public class ChildrenComparatorByAge<F extends FamilyTreeItem> implements Comparator<F> {

    @Override
    public int compare(F o1, F o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

