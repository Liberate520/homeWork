package classes.model.human.comparators;

import classes.model.human.Human;

import java.util.Comparator;

public class HumanComparatorByBrithDate<E extends Human> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        //return o1.getBrithDate() - o2.getBrithDate();
        return o1.getBrithDate().compareTo(o2.getBrithDate());
    }
}
