package homeWork.src.member;

import java.time.LocalDate;
import java.util.Comparator;

public class FamilyMemberCompareByBirthDate implements Comparator<FamilyMember> {
    @Override
    public int compare(FamilyMember o1, FamilyMember o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
