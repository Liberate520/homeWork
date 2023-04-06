package tree.comparators;

import java.util.Comparator;
import human.Human;

public class HumanComaratorByFamily implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getFamily().compareTo(o2.getFamily());
    }

    

    
}