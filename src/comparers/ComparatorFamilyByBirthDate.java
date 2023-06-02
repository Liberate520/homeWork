package comparers;
import java.util.Comparator;

import tree.Human;

/** компаратор по дню рождения */
public class ComparatorFamilyByBirthDate implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getBirthday().compareTo(o2.getBirthday());
    }
}
