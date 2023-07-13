package human;

import human.Human;
import family_tree.FamilyTreeItem;

import java.util.Comparator;

public class ComparatorByAge<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare (T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
