package OOPjavaTree.src.Tree;

import OOPjavaTree.src.Person.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int index;
    private List<Human> familyBranches;

    public HumanIterator(List<Human> familyBranches) {
        this.familyBranches = familyBranches;
    }

    @Override
    public boolean hasNext() {
        return index < familyBranches.size();
    }

    @Override
    public Human next() {
        return familyBranches.get(index++);
    }
}
