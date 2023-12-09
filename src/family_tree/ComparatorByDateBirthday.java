package family_tree;

import java.util.Comparator;

public class ComparatorByDateBirthday<E extends FamilyTreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getDateBirthday().compareTo(o2.getDateBirthday());
    }

    @Override
    public Comparator<E> reversed() {
        return Comparator.super.reversed();
    }
}
