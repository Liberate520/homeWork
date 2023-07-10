package family_tree.humans.comparators;

import java.util.Comparator;

import family_tree.human_family.HumanItem;

public class HumanComparatorByYear<T extends HumanItem> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getbirthDate().getYear(), o2.getbirthDate().getYear());

    }

}
