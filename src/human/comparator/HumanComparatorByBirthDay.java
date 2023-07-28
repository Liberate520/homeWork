package human.comparator;

import human.Human;

import java.util.Comparator;

public class HumanComparatorByBirthDay implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        if(o1.getBirthDay().isAfter(o2.getBirthDay())) {
            return 1;
        }
        else{
            return -1;
        }
    }
}
