import java.util.Comparator;

public class HumanNameComparator implements Comparator<Human> {

    @Override
    public int compare(Human h1, Human h2) {
        return h1.name.compareTo(h2.name);
    }
    
}
