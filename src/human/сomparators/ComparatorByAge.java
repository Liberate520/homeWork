package human.сomparators;

import java.util.Comparator;
import human.Human;
import tree.FamilyTreeItem;

public class ComparatorByAge<E extends FamilyTreeItem> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.age(), o2.age());
    }
}
