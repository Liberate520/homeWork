package Human.Comparators;

import java.util.Comparator;
import Human.Human;


public class HumanComporatorByName implements Comparator<Human>{
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
