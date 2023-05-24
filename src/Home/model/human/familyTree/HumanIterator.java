package Home.model.human.familyTree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E> {
    private int index;
    private List<E> humanlist;
    public HumanIterator(List<E> humanlist){
        this.humanlist = (List<E>) humanlist;
    }

    @Override
    public boolean hasNext() {
        return index < humanlist.size();
    }

    @Override
    public E next() {
        return  humanlist.get(index++);
    }
}
