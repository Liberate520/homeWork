package human.comparators;

import human.Human;

import java.util.Comparator;

public class CompHumanByDBR implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o2.getDateBirth().compareTo(o1.getDateBirth());
    }
}
