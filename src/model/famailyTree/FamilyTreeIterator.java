package model.famailyTree;

import java.util.Iterator;
import java.util.List;

import model.human.Human;

public class FamilyTreeIterator implements Iterator<Human> {
    private int index;
    private List<Human> humanList;

    public FamilyTreeIterator(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}