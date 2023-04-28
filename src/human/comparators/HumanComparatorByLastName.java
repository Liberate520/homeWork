package human.comparators;

import human.Human;

import java.util.Comparator;

public class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human human1, Human human2) {
        return human1.getLastName().compareTo(human2.getLastName());
    }
}
