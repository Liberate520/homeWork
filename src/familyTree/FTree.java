package familyTree;

import member.Member;

import java.util.List;

public interface FTree<E extends Member> extends Iterable<E> {
    List<E> getMembers();

    void addMember(E member);
}