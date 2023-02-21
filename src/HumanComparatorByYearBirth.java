import java.util.Comparator;

public class HumanComparatorByYearBirth implements Comparator<Human>{

    @Override
    public int compare (Human o1, Human o2) {       
        return Integer.compare(o1.getYearofbirth(), o2.getYearofbirth());
    }
    
}
