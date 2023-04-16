package familyTreeApi.familyTree;

import familyTreeApi.member.Member;

import java.util.List;

public interface FTree<E extends Member> extends Iterable<E> {
    List<E> getMembers();

    <E extends Member> boolean addMember(E member);
}