package homeWork.src.member;

import homeWork.src.member.FamilyMember;

import java.util.Comparator;

public class FamilyMemberComparatorByAge implements Comparator<FamilyMember> {
    @Override
    public int compare(FamilyMember o1, FamilyMember o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
