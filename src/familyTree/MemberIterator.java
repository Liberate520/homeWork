package familyTree;


import familyTree.comparators.Group;
import familyTree.member.Human;

import java.util.*;

public class MemberIterator<T> implements Iterator<T> {

    private int index;
    private final List<T> members;

    public MemberIterator(List<T> members) {
        this.members = members;

    }
    @Override
    public boolean hasNext() {
        return index < members.size();
    }

    @Override
    public T next() {
        return members.get(index++);
    }

//    @Override
//    public boolean hasNext() {
//        return !members.isEmpty();
//    }
//
//    @Override
//    public T next() {
//        if (hasNext()) {
//            T current = members.poll();
//            if (current instanceof Group) {
//                Group<T> group = (Group<T>) current;
//                for (T member : group.getMembers()) {
//                    members.offer(member);
//                }
//            }
//            return current;
//        }
//        throw new NoSuchElementException();
//    }

}
