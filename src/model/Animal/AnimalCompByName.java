package Animal;

import java.util.Comparator;


public class AnimalCompByName<T extends Animal<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
}
