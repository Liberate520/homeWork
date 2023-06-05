package comparers;
import java.util.Comparator;

import members.Member;

/** компаратор по количеству детей */
public class ComparatorFamilyByChildrenAmount<T extends Member> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getChildrenAmount(), o2.getChildrenAmount());
    }
}
