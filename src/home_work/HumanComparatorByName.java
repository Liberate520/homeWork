package home_work;

import java.util.Comparator;

public class HumanComparatorByName implements Comparator<Human>{
    public int compare(Human h1, Human h2) {
        return h1.getName().compareTo(h2.getName());
    }
}
