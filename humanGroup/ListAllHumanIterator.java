package humanGroup;

import human.Human;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ListAllHumanIterator<E> implements Iterator<E> {
    private int index;
    private ArrayList<E> listAllHuman;

    public ListAllHumanIterator(List<E> listAllHuman) {
        this.listAllHuman = (ArrayList<E>) listAllHuman;
    }

    @Override
    public boolean hasNext() {
        return listAllHuman.size() > index;
    }

    @Override
    public E next() {
        return listAllHuman.get(index++);
    }
}