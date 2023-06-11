package model.member.comparator;

import model.member.Member;

import java.util.Comparator;

public interface MemberComparator<E extends Member> extends Comparator<E> {
    @Override
    int compare(E m1, E m2);
}
