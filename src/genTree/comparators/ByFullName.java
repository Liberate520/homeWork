package genTree.comparators;

import java.util.Comparator;
import human.Human;

public class ByFullName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getFullName().compareTo(o2.getFullName());
    }
}