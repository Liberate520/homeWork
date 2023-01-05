package homeWorkSem1.Service;

import java.util.Comparator;

import homeWorkSem1.Human;

public class HumanComparatorbyId implements Comparator<Human> {
    
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
