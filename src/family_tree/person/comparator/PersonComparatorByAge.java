package family_tree.person.comparator;

import family_tree.familytree.FamilyTreeItem;
import family_tree.person.Person;

import java.util.Comparator;

public class PersonComparatorByAge<E extends FamilyTreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
