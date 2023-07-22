package family_tree.human.comparators;

import family_tree.human.Human;
import family_tree.tree.Entity;

import java.util.Comparator;

public class HumanComparatorBySecondName<T extends Entity> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getSecondName().compareTo(o2.getSecondName());
    }
}
