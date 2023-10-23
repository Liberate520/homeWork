package homeWork3.core.infrastructure;

import homeWork3.core.models.Human;

import java.util.Comparator;

public class CompareAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {

        return Integer.compare(o1.getAge(), o2.getAge());
    }
}