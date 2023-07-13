package family_tree.group.comparators;

import family_tree.group.GroupItemAgedNamed;

import java.util.Comparator;

public class ComparatorByName<E extends GroupItemAgedNamed> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
