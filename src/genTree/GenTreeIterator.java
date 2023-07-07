package genTree;

import java.util.Iterator;
import java.util.ArrayList;
import human.Human;

public class GenTreeIterator implements Iterator<Human> {
    private int index = 0;
    private int size;
    private ArrayList<Human> items;

    public GenTreeIterator(ArrayList<Human> items) {
        this.items = items;
        this.size = items.size();
    }

    @Override
    public boolean hasNext() {
        return index < size;
    }

    @Override
    public Human next() {
        Human h = items.get(index);
        index += 1;
        return h;
    }
}