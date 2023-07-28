package FamiliTree;

import java.util.Iterator;
import java.util.List;

import Human.Human;

public class FamiliTreeIterator implements Iterator <Human> {
    private int index;
    private List<Human> humansList;

    public FamiliTreeIterator(List<Human> humans) {
        this.humansList = humans;
    }

    @Override
    public boolean hasNext() {
        return humansList.size() > index;
    }

    @Override
    public Human next() {
        return humansList.get(index++);
    }

    
    
}
