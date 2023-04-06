package trees;

import familyTree.FamilyTree;

import java.util.Iterator;
import java.util.List;

public class FTreeIterator implements Iterator<FamilyTree> {
    private int index;
    private List<FamilyTree> fTrees;

    public FTreeIterator(List<FamilyTree> fTrees) {
        this.fTrees = fTrees;
    }

    @Override
    public boolean hasNext() {
        return index < this.fTrees.size();
    }

    @Override
    public FamilyTree next() {
        return this.fTrees.get(index++);
    }
}