package model.human.comparators;

import model.family_tree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByChildrenCount<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o2.getChildren().size(), o1.getChildren().size());
    }
}
