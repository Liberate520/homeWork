package tree.comparators;

import java.util.Comparator;

import tree.Human;

public class HumanComparatorByBirth implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
    
}
