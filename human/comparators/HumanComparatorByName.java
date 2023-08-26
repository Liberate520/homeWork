package human.comparators;

import human.Human;
import humanGroup.HumanGroupItem;

import java.util.Comparator;

public class HumanComparatorByName<E extends HumanGroupItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getFullName().compareTo(o2.getFullName());
    }

}