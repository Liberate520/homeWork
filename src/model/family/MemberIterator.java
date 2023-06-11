package model.family;

import model.member.Member;
import java.util.Iterator;
import java.util.List;

public class MemberIterator<E extends Member> implements Iterator<E> {
    private int index;
    private List<E> members;
    public MemberIterator(List<E> members) {
        index = 0;
        this.members = members;
    }
    @Override
    public boolean hasNext() {
        return index < members.size();
    }

    @Override
    public E next() {
        return members.get(index++);
    }
}
