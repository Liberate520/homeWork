package family_tree.human.comparators;
import java.util.Comparator;

import family_tree.human.Human;

public class HumanComparatorByAge implements Comparator<Human>  {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o2.getAge(), o1.getAge());
    }
    
}
