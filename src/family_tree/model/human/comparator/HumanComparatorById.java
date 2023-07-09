package family_tree.model.human.comparator;

import family_tree.model.tree.tree_service.TreeItem;

import java.util.Comparator;

public class HumanComparatorById<T extends TreeItem> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2){
        return Long.compare(o1.getId(), o2.getId());
    }
}
