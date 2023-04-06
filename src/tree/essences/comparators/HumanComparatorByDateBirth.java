package tree.essences.comparators;

import java.util.Comparator;

import tree.interfaces.AlliService;

public class HumanComparatorByDateBirth<E extends AlliService<E>> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o2.getDateBirth().compareTo(o1.getDateBirth());
        // return Integer.compare(o2.getDateBirth(), o1.getDateBirth());

    }

}
