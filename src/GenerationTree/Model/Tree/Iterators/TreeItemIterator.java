package GenerationTree.Model.Tree.Iterators;

import java.util.Iterator;
import java.util.List;

import GenerationTree.Model.Tree.GenTreeItem;

public class TreeItemIterator<E extends GenTreeItem> implements Iterator<E> {
    private int index;
    private List<E> persons;

    public TreeItemIterator(List<E> persons) {
        this.persons = persons;
    }

    @Override
    public boolean hasNext() {
        return persons.size() > index;
    }

    @Override
    public E next() {
        return persons.get(index++);
    }

}
