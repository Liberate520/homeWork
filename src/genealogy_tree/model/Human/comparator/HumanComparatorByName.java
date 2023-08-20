package genealogy_tree.model.Human.comparator;

import genealogy_tree.model.Tree.GeneologiTreeItem;

import java.util.Comparator;

public class HumanComparatorByName<T extends GeneologiTreeItem> implements Comparator<T> {
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
