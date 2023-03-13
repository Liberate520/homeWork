package HW.Iterator;


import java.util.Comparator;

import HW.FamilyMember;
import HW.Human;


public class HumanComparatorByName<T extends FamilyMember> implements Comparator<T> {
    @Override
    public int compare(T o, T o1) {
        return o.getName().compareTo(o1.getName());

    }

}
