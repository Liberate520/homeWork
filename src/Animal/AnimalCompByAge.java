package Animal;

import java.util.Comparator;

public class AnimalCompByAge<T extends Animal<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getBirthday().getYear() - o2.getBirthday().getYear();
    }
    
}