package GenerationTree.Model.Tree.Comparators;

import java.util.Comparator;

import GenerationTree.Model.Tree.GenTreeItem;

public class TreeItemComporatorByName<E extends GenTreeItem> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}