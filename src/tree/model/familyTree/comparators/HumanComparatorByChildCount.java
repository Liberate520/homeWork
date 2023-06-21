package tree.model.familyTree.comparators;

import tree.model.familyTree.TreeItem;
import java.util.Comparator;

public class HumanComparatorByChildCount<T extends TreeItem<T>> implements Comparator<T> {

    @Override
    public int compare(T human1, T human2) {
        return Integer.compare(human1.getChildrenList().size(), human2.getChildrenList().size());
    }
}