import java.util.Comparator;

public class HumanComparatorBySizeChildren implements Comparator<Human> {
   
    @Override
    public int compare(Human o2, Human o1) {
        return Integer.compare(o1.getChildrenSize(), o2.getChildrenSize());
    }
    
}
