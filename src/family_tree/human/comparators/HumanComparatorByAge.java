package family_tree.human.comparators;

import family_tree.human.Human;
import family_tree.tree.Entity;

import java.util.Comparator;

public class HumanComparatorByAge<T extends Entity> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(o1.getDateOfBirth(), o1.getDateOfDeath()),
                               o2.getAge(o2.getDateOfBirth(), o2.getDateOfDeath()));
    }
}
