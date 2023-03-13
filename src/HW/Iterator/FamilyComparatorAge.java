package HW.Iterator;



import java.util.Comparator;

import HW.FamilyMember;
import HW.Human;

public class FamilyComparatorAge<T extends FamilyMember> implements Comparator<T> {
   @Override
   public int compare(T o, T o1) {
      return Integer.compare(o.getAge(), o1.getAge());

   }
}
