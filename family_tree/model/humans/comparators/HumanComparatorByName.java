package family_tree.model.humans.comparators;

import java.util.Comparator;

import family_tree.model.human_family.HumanItem;

public class HumanComparatorByName<T extends HumanItem<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());

    }
}
