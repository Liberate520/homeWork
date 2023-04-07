package treePackage;

import java.util.Iterator;
import java.util.List;



public class HumanIterator extends FamilyTree implements Iterator<Human>{

    private int index;
    
    
    
    public HumanIterator(List<Human> humanList) {
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
