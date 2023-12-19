package model.tree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E> implements Iterator<E> {
    private int index;
    private List<E> memberList;

    public FamilyTreeIterator(List<E> membersList) {
        this.memberList = membersList;
    }

    @Override
    public boolean hasNext() {
        return index < memberList.size();
    }

    @Override
    public E next() {
        return memberList.get(index++);
    }
}
