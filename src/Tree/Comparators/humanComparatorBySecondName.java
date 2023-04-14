package Tree.Comparators;

import Human.Human;

import java.util.Comparator;

public class humanComparatorBySecondName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getSecondName().compareTo(o2.getSecondName());
    }
}
