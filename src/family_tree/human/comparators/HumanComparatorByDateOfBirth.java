package family_tree.human.comparators;

import family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByDateOfBirth implements Comparator<Human> {
    public int compare(Human o1, Human o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
