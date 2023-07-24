package FamilyTree.Comparator;

import Human.Human;

import java.util.Comparator;

public class SortByAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge() - o2.getAge();
    }
}
