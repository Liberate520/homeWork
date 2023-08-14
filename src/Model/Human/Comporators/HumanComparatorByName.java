package Model.Human.Comporators;

import java.util.Comparator;

import Model.FamilyTree.FamilyItem;

public class HumanComparatorByName<E extends FamilyItem<E>> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2){
        return o1.getName().compareTo(o2.getName());
    }
}
