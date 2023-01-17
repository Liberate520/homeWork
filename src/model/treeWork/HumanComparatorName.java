package model.treeWork;
import java.util.Comparator;
import java.util.List;



public class HumanComparatorName <T extends ElementTree> implements Comparator<T> {

    private List<T> famTree;
    @Override
    public int compare(T o1, T o2) {

        return o1.getName().compareTo(o2.getName());
    }
}