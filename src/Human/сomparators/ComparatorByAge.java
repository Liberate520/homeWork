package human.сomparators;

import java.util.Comparator;
import human.Human;

public class ComparatorByAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.age(), o2.age());
    }
}
