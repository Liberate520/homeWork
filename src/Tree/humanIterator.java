package Tree;

import Human.Human;

import java.util.Iterator;
import java.util.List;


class humanIterator implements Iterator<Human> {
    private int index;
    private List<Human> relatives;

    public humanIterator(List<Human> relatives) {
        this.relatives = relatives;
    }

    @Override
    public boolean hasNext() {
        return index < relatives.size();
    }

    @Override
    public Human next() {
        return relatives.get(index++);
    }
}
