package src.model;

import java.util.Comparator;

public class HumanComparatorByName <E extends Human> implements Comparator<E>{
    @Override
    public int compare(E o1, E o2) {
        int result = o1.getName().compareTo(o2.getName());
        if (result == 0 ) {
            return o1.getBirthDay().compareTo(o2.getBirthDay());
        } else {
            return result;
        }
    }
}
