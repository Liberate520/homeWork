package tree;

import human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private int index;
    private List<Human> memberList;

    public FamilyTreeIterator(List<Human> membersList) {
        this.memberList = membersList;
    }

    @Override
    public boolean hasNext() {
        return index < memberList.size();
    }

    @Override
    public Human next() {
        return memberList.get(index++);
    }
}
