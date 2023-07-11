package family_tree.creatures.comparators;

import family_tree.creatures.interfaces.Creatures;

import java.util.Comparator;

public class CreaturesComparatorByDateOfBirth<E extends Creatures> implements Comparator<E> {
    public int compare(E o1, E o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
