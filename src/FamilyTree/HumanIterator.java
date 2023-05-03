package FamilyTree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E> {
    private int index;
    private List<E> allHumans;
    public HumanIterator(List<E> allHumans){
        this.allHumans = allHumans;
    }

    @Override
    public boolean hasNext() {
        return index <allHumans.size();
    }

    @Override
    public E next() {
        return allHumans.get(index++);
    }
}
