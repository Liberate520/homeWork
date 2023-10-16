package comparators;

import java.util.Comparator;

import members.Human;
import tree_structure.Subject;

public class HumanComparatorByBirthdayDate <E extends Subject> implements Comparator<E> {
    @Override
    public int compare (E o1, E o2){
        return Integer.compare(((Human) o1).getBirthday_date(), ((Human) o2).getBirthday_date());
    }
    
}
