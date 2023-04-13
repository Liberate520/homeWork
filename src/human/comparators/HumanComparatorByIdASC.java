package human.comparators;

import human.Human;

import java.util.Comparator;

public class HumanComparatorByIdASC implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getHumanID(), o2.getHumanID());
    }
}
