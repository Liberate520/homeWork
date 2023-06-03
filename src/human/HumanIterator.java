package human;

import human.Human;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HumanIterator<F extends Human> implements Iterator<F> {
    private List<F> list;
    private int index;

    public HumanIterator(List<F> list) {
        this.list = list;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public F next() {
        return list.get(index++);
    }

    public void sortByName() {
        Collections.sort(list);
    }
}
