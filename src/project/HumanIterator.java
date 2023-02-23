package project;

import java.util.ArrayList;
import java.util.Iterator;

public class HumanIterator implements Iterator<Human>{
    private Integer index;
    private ArrayList<Human> human_list;

    public HumanIterator(ArrayList<Human> human_list) {
        this.human_list = human_list;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return human_list.size() > index;
    }

    @Override
    public Human next() {
        return human_list.get(index++);
    }
}
