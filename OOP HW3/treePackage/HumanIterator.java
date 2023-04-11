package treePackage;

import java.util.Iterator;
import java.util.List;



public class HumanIterator<E, T> extends FamilyTree <E> implements Iterator<E>{

    private int index;
    
    
    
    public HumanIterator(List<E> humanList) {
        this.humanList = (List<E>) humanList;
    }
     

    @Override
    public boolean hasNext() {
             return index < humanList.size();
    }

    @Override
    public E next() {
        
        return (E) humanList.get(index++);
    }
    
}
