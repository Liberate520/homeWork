package HW.Tree.Comparators;

import HW.Human.Human;

import java.util.Comparator;

public class SortByNameLength implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o2.getName().length() - o1.getName().length();
    }
}
