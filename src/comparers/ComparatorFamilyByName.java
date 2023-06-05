package comparers;

import members.Member;
import java.util.Comparator;

/** компаратор по имени */
public class ComparatorFamilyByName<T extends Member> implements Comparator<T> {
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
