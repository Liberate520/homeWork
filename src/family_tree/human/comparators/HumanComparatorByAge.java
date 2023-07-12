package family_tree.human.comparators;

import family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getAge(o1.getDateOfBirth(), o1.getDateOfDeath()),
                               o2.getAge(o2.getDateOfBirth(), o2.getDateOfDeath()));
    }
}
