package genealogicalTree;

import human.Human;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private ArrayList<Human> humanList;

    public HumanIterator(List<Human> humanList){
        this.humanList = this.humanList;
    }

    @Override
    public boolean hasNext() {
        return humanList.size()>index;
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }

}
