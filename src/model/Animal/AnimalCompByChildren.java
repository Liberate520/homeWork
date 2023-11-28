package Animal;

import java.util.Comparator;


public class AnimalCompByChildren<T extends Animal<T>> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        return o2.getChildren().size() - o1.getChildren().size() ;
    }
    
}
