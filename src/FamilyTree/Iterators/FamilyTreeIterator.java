package FamilyTree.Iterators;

import java.util.Iterator;
import java.util.List;

import Human.Human;

public class FamilyTreeIterator implements Iterator<Human>{
    private int index;
    private List<Human> family;

    public FamilyTreeIterator(List<Human> family){
        this.family = family;
    }

    @Override
    public boolean hasNext(){
        return index<family.size();
    }

    @Override
    public Human next(){
        return family.get(index++);
    }
}
