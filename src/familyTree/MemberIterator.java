package familyTree;


import familyTree.comparators.Group;
import member.Human;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MemberIterator<T> implements Iterator<T> {

    private int index;
    private final Queue<T> members;

    public MemberIterator(T member) {
        this.members = new LinkedList<>();
        this.members.offer(member);
    }

    @Override
    public boolean hasNext() {
        return !members.isEmpty();
    }

    @Override
    public T next() {
        if (hasNext()) {
            T current = members.poll();
            if (current instanceof Group) {
                Group<T>
            }
        }
    }

    //    @Override
//    public boolean hasNext() {
//        return index < humanList.size();
//    }
//
//    @Override
//    public E next() {
//        return humanList.get(index++);
//    }
}
