package Family_Tree.Tree;

import Family_Tree.Human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {

    private int index;
    private List<Human> humanList;

    public FamilyTreeIterator(List<Human> familyTree) {
        this.humanList = familyTree;
    }

    @Override
    public boolean hasNext() {
        return humanList.size() > index;
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }

}
