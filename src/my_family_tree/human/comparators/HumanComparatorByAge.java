package my_family_tree.human.comparators;

import my_family_tree.human.Human;
import my_family_tree.tree.TreeItem;

import java.util.Comparator;

public class HumanComparatorByAge <E extends TreeItem> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
