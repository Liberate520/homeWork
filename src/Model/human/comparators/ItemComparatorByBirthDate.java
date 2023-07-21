package Model.human.comparators;
import java.util.Comparator;

import Model.familyTree.TreeItem;

public class ItemComparatorByBirthDate<E extends TreeItem<E>> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
    
}
