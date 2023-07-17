package family_tree.model.group;

import family_tree.model.group.comparators.ComparatorByAge;
import family_tree.model.group.comparators.ComparatorByName;

public class GroupExtended<E extends GroupItemExtended> extends Group<E> implements Iterable<E> {
    public void sortByName(){
        listItem.sort(new ComparatorByName<>());
    }
    public void sortByAge(){
        listItem.sort(new ComparatorByAge<>());
    }
}