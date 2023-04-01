package tree.comparators;
import java.util.Comparator;

import human.Human;

public class HumanComparebyName implements Comparator<Human> {

    @Override
    public int compare(Human h1, Human h2) {
        return h1.getName().compareTo(h2.getName());
    }
}
