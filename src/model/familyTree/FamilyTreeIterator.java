package model.familyTree;

import model.human.TreeMember;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends TreeMember> implements Iterator<T> {
    private int index = 0;
    private final List<T> family;
    public FamilyTreeIterator(List<T> family){
        this.family = family;
    }

    @Override
    public boolean hasNext(){
        return index < family.size() && family.get(index) != null;
    }

    @Override
    public T next() {
        return family.get(index++);
    }
}
