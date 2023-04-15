package model.familyTree;

import model.human.Human;

import java.util.Iterator;
import java.util.List;


public class HumanIterator<E, T> extends FamilyTree<Human> implements Iterator<E> {

    public HumanIterator(List<E> humanList) {
        super((List<Human>) humanList);
        //TODO Auto-generated constructor stub
    }

    private int index;


    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public E next() {

        return (E) humanList.get(index++);
    }

}
