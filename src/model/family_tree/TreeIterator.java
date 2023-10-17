package model.family_tree;

import java.util.List;
import java.util.Iterator;

public class TreeIterator<T> implements Iterator<T>{

    private int index;
    private List<T> personList;
    public TreeIterator(List<T> personList) {
        this.personList = personList;
    }
    
    @Override
    public boolean hasNext() {
        return personList.size() > index;
    }

    @Override
    public T next() {
        return personList.get(index++);
    }
}
