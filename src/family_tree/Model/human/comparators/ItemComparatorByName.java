package family_tree.Model.human.comparators;
import java.util.Comparator;

import family_tree.Model.familyTree.TreeItem;

public class ItemComparatorByName<E extends TreeItem<E>> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
}
