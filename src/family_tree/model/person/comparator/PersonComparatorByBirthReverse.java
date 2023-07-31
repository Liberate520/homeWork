package family_tree.model.person.comparator;

import family_tree.model.familytree.FamilyTreeItem;

import java.util.Comparator;

public class PersonComparatorByBirthReverse<E extends FamilyTreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o2.getBirthDate().split(" ")[2].compareTo(o1.getBirthDate().split(" ")[2]);
    }
}
