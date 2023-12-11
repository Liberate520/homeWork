package ru.gb.family_tree_homework.family_tree;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<E> implements Iterator<E> {
    private List<E> familyTree;
    private int index;

    public TreeIterator(List<E> familyTree){
        this.familyTree = familyTree;
        this.index = 0;
    }

    @Override
    public boolean hasNext(){
        return index < familyTree.size();
    }

    @Override
    public E next(){
        if(hasNext()){
            E member = familyTree.get(index);
            index++;
            return member;
        } else {
            return null;
        }
    }
}
