package FamilyTree.FT;

import FamilyTree.HR.Human;
import java.util.Comparator;

public class ComparatorByBirthDate implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        if (Integer.compare(o1.getAge(), o2.getAge()) == 0) {   // getAge -> getBirthDate
            return o1.getName().compareTo(o2.getName());
        } else {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }


}
