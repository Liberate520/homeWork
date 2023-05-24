package Home.model.human.comparators;

import Home.model.human.Human;

import java.util.Comparator;

public class HumantComparatorByName<E extends Human> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
