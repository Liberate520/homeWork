package family_tree.model.group.comparators;

import family_tree.model.group.GroupItemExtended;

import java.util.Comparator;

public class ComparatorByName<E extends GroupItemExtended> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
