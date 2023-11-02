package human;

import familyTree.FamilyTreeItem;

import java.util.Comparator;

public class ObjectComparatorByBirthday<E extends FamilyTreeItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthDay().compareTo(o2.getBirthDay());
    }
}
