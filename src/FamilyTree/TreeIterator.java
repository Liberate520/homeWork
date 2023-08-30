package FamilyTree;

import Human.GroupItem;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<E extends GroupItem> implements Iterator<E> {
    private List<E> list;
    private int index;

    public TreeIterator(List<E> list){
        this.list = list;
        index = 0;
    }


    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public E next() {
        return list.get(index++);
    }
}
