package tree.familyTree.comparators;

import tree.familyTree.TreeItem;
import tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByName<T extends TreeItem> implements Comparator<T> {

    @Override
    public int compare(T human1, T human2) {
        return human1.getName().compareTo(human2.getName());
    }
}
