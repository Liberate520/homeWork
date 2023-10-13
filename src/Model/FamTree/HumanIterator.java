package Model.FamTree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E>{
    private int ind;
    private List<E> humansList;
    public  HumanIterator(List<E> humansList){
        this.humansList = humansList;
    }



    @Override
    public boolean hasNext() {
        return humansList.size()> ind;
    }

    @Override
    public E next() {
        return humansList.get(ind++);
    }
}
