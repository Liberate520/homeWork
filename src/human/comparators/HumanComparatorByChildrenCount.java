package human.comparators;

import family_tree.FamilyTreeItem;
import human.Human;

import java.util.Comparator;

public class HumanComparatorByChildrenCount<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o2.getChildren().size(), o1.getChildren().size());
    }
}
