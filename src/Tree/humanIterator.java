package Tree;

import Human.Human;

import java.util.Iterator;
import java.util.List;

class humanIterator<E extends Human> implements Iterator<E> {
    private int index;
    private List<E> relatives;

    public humanIterator(List<E> relatives) {
        this.relatives = relatives;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < relatives.size();
    }

    @Override
    public E next() {
        return relatives.get(index++);
    }
}
