package tree.model.familyTree.comparators;

import tree.model.familyTree.TreeItem;
import java.util.Comparator;

public class HumanComparatorByName<T extends TreeItem<T>> implements Comparator<T> {

    @Override
    public int compare(T human1, T human2) {
        return human1.getName().compareTo(human2.getName());
    }
}
