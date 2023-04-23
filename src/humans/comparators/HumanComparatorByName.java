package humans.comparators;

import humans.Human;

import java.util.Comparator;

public class HumanComparatorByName implements Comparator<Human> {

    @Override
    public int compare(Human h1, Human h2) {
        return h1.getFirstName().compareTo(h2.getFirstName());
    }
}
