package iterable;

import human.Human;
import java.util.Iterator;
import java.util.List;

public class iterable implements Iterator<Human> {
    private int index;
    private List<Human> humanList;

    public iterable(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
