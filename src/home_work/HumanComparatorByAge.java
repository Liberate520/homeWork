package home_work;

import java.util.Comparator;

public class HumanComparatorByAge implements Comparator<Human>{
    public int compare(Human h1, Human h2) {
        return h1.getDateOfBirth().compareTo(h2.getDateOfBirth());
    }
}
