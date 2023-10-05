package comparators;

import java.util.Comparator;

import members.Human;

public class HumanComparatorBySurname implements Comparator<Human>  {
    @Override
    public int compare (Human o1, Human o2){
        return o1.getSurName().compareTo(o2.getSurName());
    }
    
}
    

