package Project_MyFamilyTree_MVP;

import java.util.Comparator;

public class HumanComparatorByAge<T extends FamilyTreeItem> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
    
}
