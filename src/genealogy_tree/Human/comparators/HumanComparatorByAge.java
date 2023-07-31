package genealogy_tree.Human.comparators;


import genealogy_tree.Tree.GeneologiTreeItem;

import java.util.Comparator;

public class HumanComparatorByAge<T extends GeneologiTreeItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }

}
