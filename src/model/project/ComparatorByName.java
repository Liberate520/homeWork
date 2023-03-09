package model.project;

import java.util.Comparator;

public class ComparatorByName<T extends User> implements Comparator<T>{
    @Override
    public int compare(T hum1, T hum2) {
        return hum1.getName().compareTo(hum2.getName());
    }
}
