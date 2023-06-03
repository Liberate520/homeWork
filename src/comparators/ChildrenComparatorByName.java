package comparators;

import tree.FamilyTreeItem;

import java.util.Comparator;

public class ChildrenComparatorByName<F extends FamilyTreeItem> implements Comparator<F> {

    @Override
    public int compare(F o1, F o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}

