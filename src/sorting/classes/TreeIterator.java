package sorting.classes;

import java.util.Iterator;
import java.util.List;

//import tree.classes.Human;

public class TreeIterator<E> implements Iterator<E> {

    private int index = 0;
    private List<E> humanList;

    public TreeIterator (List<E> listOfHumans){
        this.humanList = listOfHumans;
    }


    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public E next() {
        return humanList.get(index++);
    }
    
}
