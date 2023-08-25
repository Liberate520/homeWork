package ru.gb.Tree.FamilyTree;

import java.util.Iterator;
import java.util.List;

import ru.gb.Tree.FamilyTree.TreeIterator;
import ru.gb.Tree.Human.Human;

class TreeIterator implements Iterator<Human>{
    private int index;
    private List<Human>humanList;

    public TreeIterator(List<Human>humanList){
        this.humanList = humanList;
    }

    public boolean hasNext(){
        return humanList.size() > index;
    }

    public Human next(){
        return humanList.get(index++);
    }
}

