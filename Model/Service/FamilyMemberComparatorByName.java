package Model.Service;
// Д.з. 4 сделать класс параметизированным
import Model.FamilyMember;
import java.util.Comparator;

public class FamilyMemberComparatorByName<T extends FamilyMember> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getNameFamilyMember().compareTo(o2.getNameFamilyMember());
    }
}