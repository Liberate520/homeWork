package comparers;
import java.util.Comparator;

import members.FamilyMember;

/** компаратор по количеству детей */
public class ComparatorFamilyByChildrenAmount<T extends FamilyMember> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getChildrenAmount(), o2.getChildrenAmount());
    }
}
