package Animal;

import java.util.Comparator;


public class AnimalCompByChildren<T extends Animal> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o1.getChildren().size() - o2.getChildren().size() ;
    }
    
}
