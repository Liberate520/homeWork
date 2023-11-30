package family_tree.model.human.comparators;

import family_tree.model.tree.HumanInterface;

import java.util.Comparator;

public class HumanComparatorByAge<T extends HumanInterface<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(o1.getBirth(),o1.getDeath()),(o2.getAge(o2.getBirth(),o2.getDeath())));
    }
}
