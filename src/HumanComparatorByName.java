

import java.util.Comparator;

public class HumanComparatorByName implements Comparator<Human> {

    @Override
    public int compare(Human human1, Human human2) {
        return human1.getFirstname().compareTo(human2.getFirstname());
    } 
}
