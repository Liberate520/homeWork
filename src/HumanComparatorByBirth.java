import java.util.Comparator;

public class HumanComparatorByBirth implements Comparator<Human>{

    @Override
    public int compare(Human h1,Human h2){
        return Integer.compare(h1.getBirth(), h2.getBirth());
    }
    
}
