package Animal;

import java.util.Comparator;

import Animal.Human.Gender;

public class AnimalCompByGender<T extends Animal<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        if (o1.getGender() == o2.getGender()){
            return 0;
        }
        if   ((o1.getGender() == Gender.Male) 
           && (o2.getGender() == Gender.Female)) return 1;
        else return -1;
    }
    
}