package member.comparator;

import member.Member;

public class MemberComparatorByName<E extends Member> implements MemberComparator<E> {
    @Override
    public int compare(E m1, E m2) {
        return String.CASE_INSENSITIVE_ORDER.compare(m1.getName(), m2.getName());
    }
}
