package Project_MyFamilyTree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human>{
    private int index;
    List<Human> humans;

    @Override
    public boolean hasNext() {
       return index < humans.size();
    }

    @Override
    public Human next() {
        return humans.get(index++);
    }

    
    
}
