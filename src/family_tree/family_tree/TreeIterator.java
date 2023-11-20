package family_tree.family_tree;

import family_tree.base.TreeNode;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<T extends TreeNode> implements Iterator<T> {
    private final List<T> list;
    private int index;

    public TreeIterator(List<T> list) {
        this.list = list;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        return list.get(index++);
    }
}
