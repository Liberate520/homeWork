package family_tree.model.person.comparators;

import family_tree.model.person.Person;
import family_tree.model.tree.Treeable;

import java.util.Comparator;

public class PersonComparatorByName<E extends Treeable<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
