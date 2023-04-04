package human;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import familyTree.FamilyTree;

public class HumanIterator implements Iterator<Human> {
    private List<Human> humanList = new ArrayList<>();;
    private int index;

    public HumanIterator(FamilyTree tree) {
        humanList = tree.getFamilyTreeList();
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public Human next() {
        return humanList.get(index++);
    }

}
