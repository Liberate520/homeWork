package homeWork.tree2.familyTree;

import homeWork.tree2.human.Human;

import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTreeIterator<E> implements Iterator<E> {

    private int index;
    public ArrayList<E> familyTree;


    public FamilyTreeIterator(ArrayList<E> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return index < familyTree.size();
    }

    @Override
    public E next() {
        return familyTree.get(index++);
    }
}

