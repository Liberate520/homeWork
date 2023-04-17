package HW_5;

import java.util.Comparator;

public class HumanComparatorByLastName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getLastname().compareTo(o2.getLastname());
    }
}
