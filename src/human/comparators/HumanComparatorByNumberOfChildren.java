package human.comparators;

import human.Human;

import java.util.Comparator;

public class HumanComparatorByNumberOfChildren implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getNumberOfChildren().compareTo(o2.getNumberOfChildren());
    }
}
