package family_tree.humans.comparators;

import java.util.Comparator;

import family_tree.humans.Human;

public class HumanComparatorByYear implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getbirthDate().getYear(), o2.getbirthDate().getYear());

    }

}
