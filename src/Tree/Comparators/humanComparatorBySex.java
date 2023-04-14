package Tree.Comparators;

import Human.Human;

import java.util.Comparator;

public class humanComparatorBySex implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getSex().compareTo(o2.getSex());
    }
}
