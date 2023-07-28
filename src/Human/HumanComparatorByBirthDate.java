package Human;

import java.util.Comparator;

public class HumanComparatorByBirthDate implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getDataOfBirth().compareTo(o2.getDataOfBirth());
    }
    
}
