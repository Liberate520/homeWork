package sorting;

import java.util.Comparator;

import classes.Human;

public class HumanComparatorByName implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
