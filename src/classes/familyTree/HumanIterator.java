package classes.familyTree;

import classes.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<Human> humanList;
    public HumanIterator(List<Human> studentList) {
        this.humanList = humanList;
    }
    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
