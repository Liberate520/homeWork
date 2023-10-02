package comparators;

import java.util.Comparator;

import members.Human;

public class HumanComparatorByBirthdayDate implements Comparator<Human> {
    @Override
    public int compare (Human o1, Human o2){
        return Integer.compare(o1.getBirthday_date(), o2.getBirthday_date());
    }
    
}
