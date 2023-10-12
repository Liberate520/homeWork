package homeWork3.model;

import java.util.Comparator;

import homeWork3.Human;

public class CompareAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {

        return Integer.compare(o1.getAge(), o2.getAge());
    }

}
