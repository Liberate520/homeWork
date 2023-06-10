package member.comparator;

import member.Member;

public class MemberComparatorByBirthDate<E extends Member> implements MemberComparator<E> {
    @Override
    public int compare(E m1, E m2) {
        return m1.getBirthDate().compareTo(m2.getBirthDate());
    }
}