import members.Human;
import java.util.*;

import comparators.HumanComparatorByBirthdayDate;
import comparators.HumanComparatorByName;
import iterators.HumanIterator;

public class HumanSort implements Iterable<Human> {
    private List<Human> humanList;
    public HumanSort (){
        humanList = new ArrayList<>();
    }
    @Override
    public Iterator<Human> iterator(){
        return new HumanIterator(humanList);
    }
    public void sortByName(){
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByBirthdate(){
        humanList.sort(new HumanComparatorByBirthdayDate());
    }
    
    
    
}
