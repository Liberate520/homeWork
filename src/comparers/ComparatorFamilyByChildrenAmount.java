package comparers;
import java.util.Comparator;

import tree.Human;

/** компаратор по количеству детей */
public class ComparatorFamilyByChildrenAmount implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getChildrenAmount(), o2.getChildrenAmount());
    }
}
