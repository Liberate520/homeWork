package comparators;

import java.util.Comparator;

import members.Human;
import tree_structure.Subject;

public class HumanComparatorByName <E extends Subject> implements Comparator<E>  {
    @Override
    public int compare (E o1, E o2){
        return ((Human) o1).getName().compareTo(((Human) o2).getName());
    }
    
}
