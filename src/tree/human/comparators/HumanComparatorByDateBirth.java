package tree.human.comparators;

import java.util.Comparator;

import tree.human.Human;

public class HumanComparatorByDateBirth implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o2.getDateBirth().compareTo(o1.getDateBirth());
        // return Integer.compare(o2.getDateBirth(), o1.getDateBirth());

    }

}
