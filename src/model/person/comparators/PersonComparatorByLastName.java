package model.person.comparators;

import model.interfaces.Anthropoid;

import java.util.Comparator;

public class PersonComparatorByLastName<E extends Anthropoid> implements Comparator<E> {
//    @Override
//    public int compare(E o1, E o2) {
//        return o1.getLastName().compareTo(o2.getLastName());

    @Override
    public int compare(E o1, E o2) {
        int firstStage = o1.getLastName().compareTo(o2.getLastName());
        if (firstStage == 0) {
            int secondStage = o1.getFirstName().compareTo(o2.getFirstName());
            if (secondStage == 0) {
                int thirdStage = Integer.compare(o1.getAge(), o2.getAge());
                return thirdStage;
            }
            return secondStage;
        }
        return firstStage;
    }
}
