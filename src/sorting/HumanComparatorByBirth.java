package sorting;

import java.util.Comparator;

import classes.Human;

public class HumanComparatorByBirth implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getBirthDate(), o2.getBirthDate());
    }
    
}
