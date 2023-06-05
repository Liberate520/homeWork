package comparers;
import java.util.Comparator;

import members.Member;

/** компаратор по дню рождения */
public class ComparatorFamilyByBirthDay<T extends Member> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
