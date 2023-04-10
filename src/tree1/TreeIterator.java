package tree1;
import java.util.Iterator;
import java.util.List;

import human1.Human;

public class TreeIterator implements Iterator<Human> {
    private int index;
    private List<Human> humanList;
    
    public TreeIterator(List<Human> humanList) {
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
