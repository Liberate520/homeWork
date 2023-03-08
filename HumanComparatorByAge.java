package Java_OOP.homeWork;

import java.util.Comparator;

public class HumanComparatorByAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getYearOfBirth(), o2.getYearOfBirth());
    }

}
