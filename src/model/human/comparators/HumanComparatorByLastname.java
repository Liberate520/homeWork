package model.human.comparators;
import model.familytree.FamilyTreeItem;
import java.util.Comparator;

public class HumanComparatorByLastname<T extends FamilyTreeItem> implements Comparator<T> {
    @Override
    public int compare(T t1, T t2) {
        return t1.getLastname().compareTo(t2.getLastname());
    }
}
