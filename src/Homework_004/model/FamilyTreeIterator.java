package Homework_004.model;

import java.util.Iterator;
import java.util.List;

    
public class FamilyTreeIterator <T extends BaseType> implements Iterator<T> {

    private List<T> humanList;
    private int index;
    
    public FamilyTreeIterator(List<T> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public T next() {
        return humanList.get(index++);
    }
}

