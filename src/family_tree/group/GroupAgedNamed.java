package family_tree.group;

import family_tree.group.comparators.ComparatorByAge;
import family_tree.group.comparators.ComparatorByName;

public class GroupAgedNamed<E extends GroupItemAgedNamed> extends Group<E> implements Iterable<E> {
    public void sortByName(){
        listItem.sort(new ComparatorByName<>());
    }
    public void sortByAge(){
        listItem.sort(new ComparatorByAge<>());
    }
}