package ru.gb.family_tree.model;

import java.util.Iterator;
import java.util.List;

public class
FamilyTreeIterator implements Iterator<Human> {
    private List<Human> family;
    private int index;

    public FamilyTreeIterator(List<Human> family){
        this.family = family;
        this.index = 0;
    }

    @Override
    public boolean hasNext(){
        return index < family.size();
    }

    @Override
    public Human next(){
        if(hasNext()){
            Human member = family.get(index);
            index++;
            return member;
        } else {
            return null;
        }
    }
}
