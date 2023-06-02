package homeWork.tree2.familyTree;

import homeWork.tree2.human.Human;

import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTreeIterator implements Iterator<Human> {

    private int index;
    public ArrayList<Human> familyTree;


    public FamilyTreeIterator(ArrayList<Human> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return index < familyTree.size();
    }

    @Override
    public Human next() {
        return familyTree.get(index++);
    }
}
