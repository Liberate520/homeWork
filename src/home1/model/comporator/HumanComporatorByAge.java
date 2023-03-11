package home1.model.comporator;

import java.util.Comparator;

import home1.model.Human;

public class HumanComporatorByAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {

        return Integer.compare(o1.getAge(), o2.getAge());
    }

}
