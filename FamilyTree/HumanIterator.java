package homeWork.FamilyTree;

import java.util.Iterator;
import java.util.List;

import homeWork.human.Human;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<FamilyTree> familyTree;

    public HumanIterator(List<FamilyTree> humanList) {
        this.familyTree = humanList;
    }

    @Override
    public boolean hasNext() {
        return familyTree.size() > index;
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }
}
