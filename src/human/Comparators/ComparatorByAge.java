package human.Comparators;

import human.Human;
import tree.FamilyTreeItem;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

public class ComparatorByAge<T extends FamilyTreeItem > implements Comparator< T > {


    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
