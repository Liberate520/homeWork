package tree;

import java.util.Iterator;
import java.util.List;

import members.FamilyMember;

class FamilyTreeIterator<T extends FamilyMember> implements Iterator<T>{
        
    private int index = 0;
    private List<T> family;
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