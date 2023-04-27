import java.util.Comparator;

public class HumanBirthYearComparator implements Comparator<Human> {

    @Override
    public int compare(Human h1, Human h2) {
        return Integer.compare(h1.birthYear, h2.birthYear);
    }
    
}
