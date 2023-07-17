package ru.gb.family_tree.familytree;


import ru.gb.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human>{
    private List<Human> humanList;
    private int index;
    public HumanIterator(List<Human> humanList) {
        this.humanList = humanList;
    }


    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}