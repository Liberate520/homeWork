package familyApi.comparator;

import java.util.Comparator;

import familyApi.User;

public class HumanComparatorByDate<T extends User> implements Comparator<T> {

    @Override
    public int compare(T human1, T human2) {
        return human1.getBirthdate().compareTo(human2.getBirthdate());
    } 
    
}
