package human.сomparators;

import java.util.Comparator;
import human.Human;
import tree.FamilyTreeItem;

public class ComparatorByName<E extends FamilyTreeItem> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
