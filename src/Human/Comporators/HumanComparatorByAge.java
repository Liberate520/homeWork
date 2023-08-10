package Human.Comporators;

import java.util.Comparator;

import FamilyTree.FamilyItem;

public class HumanComparatorByAge<E extends FamilyItem<E>> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2){
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
