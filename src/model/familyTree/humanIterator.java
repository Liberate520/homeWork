package model.familyTree;

import java.util.Iterator;
import java.util.List;

public class humanIterator<E extends commonParam> implements Iterator<E> {
    private int index = 0;
    private final List<E> List;

    public humanIterator(List<E> List){
        this.List = List;
    }

    @Override
    public boolean hasNext(){
        return index < List.size();
    }
    @Override
    public E next(){
        return List.get(index++);
    }
}
