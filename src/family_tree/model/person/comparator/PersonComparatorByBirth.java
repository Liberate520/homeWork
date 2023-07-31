package family_tree.model.person.comparator;

import family_tree.model.familytree.FamilyTreeItem;

import java.util.Comparator;

public class PersonComparatorByBirth<E extends FamilyTreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthDate().split(" ")[2].compareTo(o2.getBirthDate().split(" ")[2]);
    }
}