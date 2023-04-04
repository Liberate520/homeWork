import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getPerson_name().compareTo(o2.getPerson_name());
    }
    
}
