package home_work;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human>{
    private int index;
    private List<Human> humanList;

    public HumanIterator(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean hasNext() {
        return humanList.size() > index;
    }

    public Human next() {
        return humanList.get(index++);
    }
}
