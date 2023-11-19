package ru.medved_sa.tree_family.familyTree.iterator;

import ru.medved_sa.tree_family.familyTree.EntityCreation;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T extends EntityCreation<T>> implements Iterator<T> {
    private int index;
    private List<T> studentList;

    public HumanIterator(List<T> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean hasNext() {
        return index < studentList.size();
    }

    @Override
    public T next() {
        return studentList.get(index++);
    }
}
