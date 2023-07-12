package family_tree.human.comparators;

import family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByFathersName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getFathersName().compareTo(o2.getFathersName());
    }
}
