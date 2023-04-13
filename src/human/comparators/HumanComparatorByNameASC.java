package human.comparators;

import human.Human;

import java.util.Comparator;

public class HumanComparatorByNameASC implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getHumanName().compareTo(o2.getHumanName());
    }
}
