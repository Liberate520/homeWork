import java.util.Comparator;

public class ComparatorById implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getPerson_id(), o2.getPerson_id());
    }
    
}
