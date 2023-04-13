package human.comparators;

import human.Human;

import java.util.Comparator;

public class HumanComparatorByIdDESC implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return -1*Integer.compare(o1.getHumanID(), o2.getHumanID());
    }
}
