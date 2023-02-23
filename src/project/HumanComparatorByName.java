package project;

import java.util.Comparator;

public class HumanComparatorByName implements Comparator<Human>{
    @Override
    public int compare(Human hum1, Human hum2) {
        return hum1.getName().compareTo(hum2.getName());
    }
}
