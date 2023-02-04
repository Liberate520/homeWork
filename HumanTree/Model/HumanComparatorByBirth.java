package Model;
import java.util.Comparator;

public class HumanComparatorByBirth<E extends Human> implements Comparator<E>{

    @Override
    public int compare(E o1, E o2) {       
        return Integer.compare(o1.getBirth(), o2.getBirth());
    }    

}
