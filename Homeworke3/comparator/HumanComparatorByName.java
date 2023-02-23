package homeWork.Homeworke3.comparator;

import java.util.Comparator;

import homeWork.Homeworke3.Human;

public class HumanComparatorByName implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getFullName().compareTo(o2.getFullName());
    }
    
}
