package homeWork_OOP_family_tree.infoHuman;

import java.util.Iterator;
import java.util.List;

import homeWork_OOP_family_tree.comparatorAndIterator.Node;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}
