package treeComparators;

import treeWorkspace.TreeItem;

import java.util.Comparator;

public class ComparatorByAge<E extends TreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E p1, E p2) {
        return p1.getAge()- p2.getAge();
    }
}
