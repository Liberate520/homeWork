import java.util.Comparator;

public class NumComporator implements Comparator<Num> {
    /**
     * сортирует по поледней цифре 
     */
    @Override
    public int compare(Num o1, Num o2) {
        Integer n1 = o1.getMynum()%10;
        Integer n2 = o2.getMynum()%10;
        return Integer.compare(n1, n2);
    }
    
}
