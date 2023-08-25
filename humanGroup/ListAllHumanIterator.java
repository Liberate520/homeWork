package humanGroup;

import human.Human;

import java.util.ArrayList;
import java.util.Iterator;

class ListAllHumanIterator implements Iterator<Human> {
    private int index;
    private ArrayList<Human> listAllHuman;

    public ListAllHumanIterator(ArrayList<Human> listAllHuman) {
        this.listAllHuman = listAllHuman;
    }

    @Override
    public boolean hasNext() {
        return listAllHuman.size() > index;
    }

    @Override
    public Human next() {
        return listAllHuman.get(index++);
    }
}