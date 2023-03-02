package model.project;

import java.util.ArrayList;
import java.util.Iterator;

public class TreeIterator<T extends User> implements Iterator<T>{
    private Integer index;
    private ArrayList<T> human_list;

    public TreeIterator(ArrayList<T> human_list) {
        this.human_list = human_list;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return human_list.size() > index;
    }

    @Override
    public T next() {
        return human_list.get(index++);
    }
}
