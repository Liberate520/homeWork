package Classes;

import java.util.Comparator;

public class HumanComparatorByName implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        // return name.compareTo(o.getName());
        return o1.getName().compareTo(o2.getName());
    }
}
