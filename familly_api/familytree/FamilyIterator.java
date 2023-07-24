package familly_api.familytree;

import java.util.Iterator;
import java.util.List;

import familly_api.human.Node;

public class FamilyIterator<E extends Node> implements Iterable<E>, Iterator<E>{
       int index;
    List<E> familyHuman;

    public FamilyIterator(List<E> familyHuman) {
        this.familyHuman = familyHuman;
    }


    public boolean hasNext() {
        return familyHuman.size() > index;
    }


    public E next() {
        return familyHuman.get(index++);
    }


    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}
