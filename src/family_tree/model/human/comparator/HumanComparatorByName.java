package family_tree.model.human.comparator;

import family_tree.model.tree.tree_service.TreeItem;

import java.util.Comparator;

public class HumanComparatorByName<T extends TreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2){
        return o1.getFullName().compareTo(o2.getFullName());
    }

}
