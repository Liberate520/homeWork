package Project_MyFamilyTree;

import java.util.Comparator;

public class HumanComparatorByAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
    
}
