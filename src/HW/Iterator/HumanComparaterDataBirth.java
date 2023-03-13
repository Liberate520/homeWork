package HW.Iterator;


import java.util.Comparator;

import HW.FamilyMember;
import HW.Human;

public class HumanComparaterDataBirth<T extends FamilyMember>  implements Comparator<T>  {
    @Override
    public int compare(T o, T o1) {
        return o.getDateBirth().compareTo(o1.getDateBirth());

    }

}