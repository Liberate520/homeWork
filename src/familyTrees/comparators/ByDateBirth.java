package familyTrees.comparators;

import human.Human;

import java.util.Comparator;

public class ByDateBirth implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getYearOfBirth().compareTo(o2.getYearOfBirth());
    }
}
