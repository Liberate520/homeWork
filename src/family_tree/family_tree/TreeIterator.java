package family_tree.family_tree;

import family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class TreeIterator <E extends TreeNode<E>>implements Iterator<E> {
    private int index;
    private List<E> list;

    public TreeIterator(List<E> list){
        this.list = list;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return list.size() > index;
    }

    @Override
    public E next() {
        return list.get(index++);
    }
}
