package human.сomparators;

import java.util.Comparator;
import human.Human;

public class ComparatorByName implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
