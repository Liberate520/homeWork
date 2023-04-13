package human.comparators;

import human.Human;

import java.util.Comparator;

public class HumanComparatorByNameDESC implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o2.getHumanName().compareTo(o1.getHumanName());
    }
}
