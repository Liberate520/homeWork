package faminly_tree.tree;

import faminly_tree.human.Human;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human>{
    private List<Human> list = new ArrayList<>();
    private int index;

    public HumanIterator(List<Human> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return list.size() > index;
    }

    @Override
    public Human next() {
        return list.get(index++);
    }
}
