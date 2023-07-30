package human.comparators;

import family_tree.FamilyTreeItem;
import human.Human;

import java.util.Comparator;

public class HumanComparatorByName<E extends FamilyTreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}