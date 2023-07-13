package family_tree.model.humans.comparators;

import java.util.Comparator;

import family_tree.model.human_family.HumanItem;

public class HumanComparatorByYear<T extends HumanItem<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getbirthDate().getYear(), o2.getbirthDate().getYear());

    }

}
