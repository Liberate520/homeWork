package human.comparators;

import human.Human;

import java.util.Comparator;

public class HumanComparatorByFirstName implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getFirstName().compareTo(h2.getFirstName());
    }
}
