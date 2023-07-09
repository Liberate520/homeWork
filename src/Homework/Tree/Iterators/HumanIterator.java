package Homework.Tree.Iterators;

import Homework.Human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<Human> familyList;

    public HumanIterator(List<Human> studentList) {
        this.familyList = familyList;
    }

    @Override
    public boolean hasNext() {
        return index < familyList.size();
    }

    @Override
    public Human next() {
        return familyList.get(index++);
    }
}
