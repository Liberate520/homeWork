package GenerationTree.Comparators;

import java.util.Comparator;

import GenerationTree.interfaces.GenTreeItem;

public class TreeItemComparatorByAge<E extends GenTreeItem<E>> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getDateBirth().compareTo(o2.getDateBirth());
    }

}
