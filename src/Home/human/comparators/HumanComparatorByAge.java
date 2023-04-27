package Home.human.comparators;

import Home.human.Human;

import java.util.Comparator;

public class HumanComparatorByAge<E extends Human> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}


