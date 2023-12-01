package Comparators;

import Human.Human;
import java.util.Comparator;

public class ComparatorByFamilyName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getFamilyName().compareTo(o2.getFamilyName());
    }
}
