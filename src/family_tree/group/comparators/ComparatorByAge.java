package family_tree.group.comparators;

import family_tree.group.GroupItemAgedNamed;

import java.util.Comparator;

public class ComparatorByAge<E extends GroupItemAgedNamed> implements Comparator<E> {
    @Override
    public int compare(E e1, E e2) {
        return e1.getAge() - e2.getAge();     //Integer.compare(h1.getAge(), h2.getAge());
    }
}
