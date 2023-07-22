package family_tree.model.tree;

import family_tree.model.human.Human;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<E> implements Iterator<E> {
    private int index;
    private List<E> family;

    public TreeIterator(List<E> family){
        this.index = index;
        this.family = family;
    }

    @Override
    public boolean hasNext() {
        return family.size() > index;
    }

    @Override
    public E next() {
        return family.get(index++);
    }
}
