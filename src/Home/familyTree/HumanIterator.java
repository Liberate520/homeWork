package Home.familyTree;

import Home.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<Human> humanlist;
    public HumanIterator(List<Human> humanlist){
        this.humanlist = humanlist;
    }

    @Override
    public boolean hasNext() {
        return index < humanlist.size();
    }

    @Override
    public Human next() {
        return humanlist.get(index++);
    }
}
