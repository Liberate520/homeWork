package project;

import java.util.Comparator;

public class HumanComparatorByYear implements Comparator<Human>{
    @Override
    public int compare(Human hum1, Human hum2) {
        return Integer.compare(hum1.getYearOfBirth(), hum2.getYearOfBirth());
    }
}