package Project_MyFamilyTree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T extends FamilyTreeItem> implements Iterator<T>{
    private int index;
    List<T> humans;

    @Override
    public boolean hasNext() {
       return index < humans.size();
    }

    @Override
    public T next() {
        return humans.get(index++);
    }

    
    
}
