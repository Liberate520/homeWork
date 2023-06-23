package comparator;

import familytree.TreeItem;
import human.Human;

import java.util.Comparator;

public class HumanComparatorById<T extends TreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o2.getId(), o1.getId());
    }


}
