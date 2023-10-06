package FamTree;

import Human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int ind;
    private List<Human> humansList;
    public  HumanIterator(List<Human> humansList){
        this.humansList = humansList;
    }

    @Override
    public boolean hasNext() {
        return humansList.size()> ind;
    }

    @Override
    public Human next() {
        return humansList.get(ind++);
    }
}
