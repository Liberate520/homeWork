package ru.geekbrains.family_tree.model.family_tree;

import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTreeIterator<E> implements Iterator<E> {

    private int index;
    private ArrayList<E> familyMembers;

    public FamilyTreeIterator(ArrayList<E> familyMembers) {
        this.familyMembers = familyMembers;
    }

    @Override
    public boolean hasNext() {
        return index < familyMembers.size();
    }

    @Override
    public E next() {
        return familyMembers.get(index++);
    }

}
