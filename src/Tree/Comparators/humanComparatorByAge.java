package Tree.Comparators;

import Human.Human;

import java.util.Comparator;

public class humanComparatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getBirth_year(), o2.getBirth_year());
    }
}
