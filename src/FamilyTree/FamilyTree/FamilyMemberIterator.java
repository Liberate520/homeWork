package FamilyTree.FamilyTree;

import Human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyMemberIterator implements Iterator<Human> {
    private int index;
    private List<Human> familyTree;

    public FamilyMemberIterator(List<Human> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return familyTree.size() > index;
    }

    @Override
    public Human next() {
        return familyTree.get(index++);
    }
}
