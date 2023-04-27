package java_oop_homeWork.src.kinsman.comparators;

import java_oop_homeWork.src.kinsman.Kinsman;

import java.util.Comparator;

public class KinsmanComparatorByName implements Comparator<Kinsman> {
    @Override
    public int compare(Kinsman o1, Kinsman o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
