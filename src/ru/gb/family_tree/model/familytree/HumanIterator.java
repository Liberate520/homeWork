package ru.gb.family_tree.model.familytree;


import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E> {
    private List<E> humanList;
    private int index;
    public HumanIterator(List<E> humanList) {
        this.humanList = humanList;
    }


    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public E next() {
        return humanList.get(index++);
    }
}