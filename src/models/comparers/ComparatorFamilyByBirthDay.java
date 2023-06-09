package models.comparers;
import java.util.Comparator;

import models.members.FamilyMember;

/** компаратор по дню рождения */
public class ComparatorFamilyByBirthDay<T extends FamilyMember> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
