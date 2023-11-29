package Human.Comparators;

import java.util.Comparator;

import Human.Human;

public interface HumanComparator extends Comparator<Human> {
    public int compare(Human o1, Human o2);
}