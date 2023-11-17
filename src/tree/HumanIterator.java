package tree;

import human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator< Human > {
    private int index;
    private List<Human> FamilyList;

    public HumanIterator(List<Human> FamilyList) {
        this.FamilyList = FamilyList;
    }
    @Override
    public boolean hasNext() {
        return index<FamilyList.size();
    }

    @Override
    public Human next() {
        return FamilyList.get(index++);
    }
}
