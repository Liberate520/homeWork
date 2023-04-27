package java_oop_homeWork.src.kinsman.comparators;

import java_oop_homeWork.src.kinsman.Kinsman;

import java.util.Comparator;

public class KinsmanComparatorByDateBirth implements Comparator<Kinsman> {
    @Override
    public int compare(Kinsman o1, Kinsman o2) {
        return o1.getDateBirth().compareTo(o2.getDateBirth());
    }
}
