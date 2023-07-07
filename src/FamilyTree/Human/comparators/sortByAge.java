package FamilyTree.Human.comparators;

import FamilyTree.Human.Human;

import java.util.Comparator;

public class sortByAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
