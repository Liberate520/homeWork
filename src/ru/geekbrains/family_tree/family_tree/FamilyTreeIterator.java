package ru.geekbrains.family_tree.family_tree;

import java.util.ArrayList;
import java.util.Iterator;

import ru.geekbrains.family_tree.human.Human;

public class FamilyTreeIterator implements Iterator<Human> {

    private int index;
    private ArrayList<Human> familyMembers;

    public FamilyTreeIterator(ArrayList<Human> familyMembers) {
        this.familyMembers = familyMembers;
    }

    @Override
    public boolean hasNext() {
        return index < familyMembers.size();
    }

    @Override
    public Human next() {
        return familyMembers.get(index++);
    }

}
