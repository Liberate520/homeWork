package ru.gb.Tree.Model.FamilyTree;

import java.util.Iterator;
import java.util.List;

class TreeIterator <T> implements Iterator<T>{
    private int index;
    private List<T>humanList;

    public TreeIterator(List<T>humanList){
        this.humanList = humanList;
    }

    public boolean hasNext(){
        return humanList.size() > index;
    }

    public T next(){
        return humanList.get(index++);
    }

}

