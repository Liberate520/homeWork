package familyTree;

import java.util.Iterator;
import java.util.List;

public class PetIterator<E> implements Iterator<E> {

    private int index;
    private List<E> petList;

    public PetIterator(List<E> petList) {
        this.petList = petList;
    }

    @Override
    public boolean hasNext() {
        return index < petList.size();
    }

    @Override
    public E next() {
        return petList.get(index++);
    }

}
