package family_tree.model.creatures.comparators;

import family_tree.model.creatures.interfaces.Creatures;

import java.util.Comparator;

public class CreaturesComparatorById <E extends Creatures> implements Comparator<E> {
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getId(),o2.getId());
    }
}
