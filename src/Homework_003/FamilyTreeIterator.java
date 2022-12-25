package Homework_003;

import java.util.Iterator;
import java.util.List;

    
public class FamilyTreeIterator implements Iterator<Human> {

    private List<Human> humanList;
    private int index;
    
    public FamilyTreeIterator(List<Human> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}

