package family_tree.human.comparators;

import family_tree.human.Human;

import java.util.Comparator;

public class HumanComparatorByAge implements Comparator<Human> {
    @Override
    public int compare(Human h1, Human h2) {
        return h1.getAge() - h2.getAge();     //Integer.compare(h1.getAge(), h2.getAge());
    }
}
