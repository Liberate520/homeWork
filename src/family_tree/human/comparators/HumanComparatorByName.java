package family_tree.human.comparators;

import java.util.Comparator;

import family_tree.human.Human;

public class HumanComparatorByName implements Comparator<Human>{
    @Override
    public int compare(Human arg0, Human arg1) {
        return arg0.getName().compareTo(arg1.getName());
    }
}
