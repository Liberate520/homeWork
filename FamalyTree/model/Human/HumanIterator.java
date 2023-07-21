package homeWork.FamalyTree.model.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E>{
    private int index;
    private List<E> humanList;
    
    public HumanIterator(List<E> humanList) {
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public E next() {
        return humanList.get(index++);
    }
    
    
}