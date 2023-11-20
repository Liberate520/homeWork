package Human.Comparators;

import java.util.Comparator;

import Human.Gender;
import Human.Human;

public class HumanCompByGender implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        if (o1.getGender() == o2.getGender()){
            return 0;
        }
        if   ((o1.getGender() == Gender.Male) 
           && (o2.getGender() == Gender.Female)) return 1;
        else return -1;
    }
    
}