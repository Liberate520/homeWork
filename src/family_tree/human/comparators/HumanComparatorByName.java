package family_tree.human.comparators;

import java.util.Comparator;

import family_tree.family_trees.TreeItem;

public class HumanComparatorByName<E extends TreeItem> implements Comparator<E>{
    @Override
    public int compare(E arg0, E arg1) {
        return arg0.getName().compareTo(arg1.getName());
    }
}
