package Human.comparators;
import java.util.Comparator;

import Human.Human;
import Tree.TreeCommon;

public class HumanComparatorByName<E extends TreeCommon> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
