package family_tree.human.comparators;

import java.util.Comparator;

import family_tree.human.Human;

public class HumanComparatorByAge implements Comparator<Human>{
    @Override
    public int compare(Human arg0, Human arg1) {
        return arg0.getAge() - arg1.getAge();
    }
}
