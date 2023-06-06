package homeWork.tree2.tests;

import homeWork.tree2.human.HumanObjectInterface;

import java.util.Comparator;

public class TestComparator<E extends HumanObjectInterface> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }

    @Override
    public Comparator<E> reversed() {
        return Comparator.super.reversed();
    }
}
