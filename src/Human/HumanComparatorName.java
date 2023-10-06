package Human;

import Human.Human;

import java.util.Comparator;

public class HumanComparatorName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }
}
