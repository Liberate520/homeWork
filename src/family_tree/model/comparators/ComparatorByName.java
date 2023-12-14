package family_tree.model.comparators;

import java.util.Comparator;

import family_tree.model.family_trees.TreeItem;

public class ComparatorByName<E extends TreeItem<E>> implements Comparator<E>{
    @Override
    public int compare(E arg0, E arg1) {
        return arg0.getName().compareTo(arg1.getName());
    }
}
