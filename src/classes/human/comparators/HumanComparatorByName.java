package classes.human.comparators;

import classes.human.Human;

import java.util.Comparator;

public class HumanComparatorByName<E extends Human> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        // return name.compareTo(o.getName());
        return o1.getName().compareTo(o2.getName());
    }
}
