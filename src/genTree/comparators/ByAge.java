package genTree.comparators;

import java.util.Comparator;
import human.Human;

public class ByAge implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge() - o2.getAge();
    }
}