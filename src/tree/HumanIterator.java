package tree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human>{

    private int count;
    private List<Human> humanList;

    public HumanIterator(List<Human> humanList){
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return count < humanList.size();
    }

    @Override
    public Human next() {
       return humanList.get(count++);
    }
    
}
