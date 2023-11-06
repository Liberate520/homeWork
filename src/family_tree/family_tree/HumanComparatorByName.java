package family_tree.family_tree;

import family_tree.human.Human;
import java.util.Comparator;


public class HumanComparatorByName implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {

        return o1.getLastName().compareTo(o2.getLastName());
    }



}
