package homeWorkSem1.Service;

import java.util.Comparator;

import homeWorkSem1.Human;

public class HumanComparatorbyAge implements Comparator<Human> {
    
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
