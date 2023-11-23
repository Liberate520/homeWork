package model.familyTree.iterators;

import java.util.Iterator;
import java.util.List;
//переделала HumanIterator в ObjectIterator - чтобы перебирать можно было не только людей,
//но и потенциальных собачек
public class ObjectIterator<E> implements Iterator<E> {
    private int id;
    private List<E> objectList;

    public ObjectIterator(List<E> objectList) {
        this.objectList = objectList;
    }

    @Override
    public boolean hasNext() {
        return id < objectList.size();
    }

    @Override
    public E next() {
        return objectList.get(id++);
    }
}
