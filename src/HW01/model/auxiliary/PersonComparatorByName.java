package HW01.model.auxiliary;

import HW01.model.Basic;
import java.util.Comparator;

public class PersonComparatorByName<T extends Basic> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
