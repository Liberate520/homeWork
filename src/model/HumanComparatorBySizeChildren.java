package model;
import java.util.Comparator;

public class HumanComparatorBySizeChildren<T extends UserParametrized> implements Comparator<T> {
   
    @Override
    public int compare(T o2, T o1) {
        return Integer.compare(o1.getChildrenSize(), o2.getChildrenSize());
    }
    
}
