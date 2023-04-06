package tree.essences.comparators;

import java.util.Comparator;
import tree.interfaces.AlliService;

public class HumanComparatorByFirstName<E extends AlliService<E>> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getFirstName().compareTo(o2.getFirstName());
    }

}
