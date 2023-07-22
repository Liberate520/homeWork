package family_tree.model.creatures.comparators;

import family_tree.model.creatures.interfaces.Creatures;

import java.util.Comparator;

public class CreaturesComparatorByAge<E extends Creatures> implements Comparator<E> {
    public int compare(E o1, E o2) {
        return Long.compare(o1.getAge(), o2.getAge());
    }
}
