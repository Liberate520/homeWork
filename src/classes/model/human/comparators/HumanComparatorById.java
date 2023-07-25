package classes.model.human.comparators;

import classes.model.human.Human;

import java.util.Comparator;

public class HumanComparatorById<E extends Human> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getId() - o2.getId();
    }
}
