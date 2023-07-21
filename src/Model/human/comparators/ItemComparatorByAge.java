package Model.human.comparators;
import java.util.Comparator;

import Model.familyTree.TreeItem;

public class ItemComparatorByAge<E extends TreeItem<E>> implements Comparator<E>  {

    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o2.getAge(), o1.getAge());
    }
    
}
