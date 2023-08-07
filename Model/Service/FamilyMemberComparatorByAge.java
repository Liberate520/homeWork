package Model.Service;

import Model.FamilyMember;
import java.util.Comparator;

public class FamilyMemberComparatorByAge implements Comparator<FamilyMember> {
    @Override
    public int compare(FamilyMember o1, FamilyMember o2) {
        return Integer.compare(o2.getAgeFamilyMember(), o1.getAgeFamilyMember());
    }
}
