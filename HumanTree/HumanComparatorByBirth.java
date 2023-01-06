import java.util.Comparator;

public class HumanComparatorByBirth implements Comparator<Human>{

    @Override
    public int compare(Human o1, Human o2) {       
        return Integer.compare(o1.getBirth(), o2.getBirth());
    }    

}
