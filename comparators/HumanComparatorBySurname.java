package comparators;

import java.util.Comparator;

import members.Human;
import tree_structure.Subject;

public class HumanComparatorBySurname <E extends Subject> implements Comparator<E>  {
    @Override
    public int compare (E o1, E o2){
        return ((Human) o1).getSurName().compareTo(((Human) o2).getSurName());
    }
    
}
    

