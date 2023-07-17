package classes.human.comparators;

import classes.human.Human;

import java.util.Comparator;

public class HumanComparatorByBrithDate implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        //return o1.getBrithDate() - o2.getBrithDate();
        return o1.getBrithDate().compareTo(o2.getBrithDate());
    }
}
