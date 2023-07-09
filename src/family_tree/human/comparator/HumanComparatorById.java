package family_tree.human.comparator;

import family_tree.human.Human;
import family_tree.tree.tree_service.TreeItem;

import java.util.Comparator;

public class HumanComparatorById<T extends TreeItem> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2){
        return Long.compare(o1.getId(), o2.getId());
    }
}
