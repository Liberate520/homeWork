package familyTree.human.comparators;

import familyTree.familyTree.FamilyGroupItem;
import familyTree.human.Human;

import java.util.Comparator;

public class HumanComparatorByAge<T extends FamilyGroupItem>
        implements Comparator<T> {
    @Override
    public int compare(T o1, T o2){
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
