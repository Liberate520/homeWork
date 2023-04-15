//package treePackage;

import java.util.Iterator;
import java.util.List;
import model.familyTree.FamilyTree;
import model.human.Human;


public class HumanIterator<E extends Human, T> extends FamilyTree<E>  implements Iterator<E>{

    private int index;
    
    
    
    public HumanIterator(List<Human> humanList) {
        this.humanList = (List<E>) humanList;
    }
     

    @Override
    public boolean hasNext() {
             return index < humanList.size();
    }

    @Override
    public E next() {
        
        return (E) humanList.get(index++);
    }
    
}
