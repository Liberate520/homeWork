package ru.medved_sa.tree_family.familyTree.iterator;

import ru.medved_sa.tree_family.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<Human> studentList;

    public HumanIterator(List<Human> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean hasNext() {
        return index < studentList.size();
    }

    @Override
    public Human next() {
        return studentList.get(index++);
    }
}
