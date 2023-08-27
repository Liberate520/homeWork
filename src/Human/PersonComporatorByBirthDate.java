package Human;
import java.util.Comparator;

public class PersonComporatorByBirthDate implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getBirth().compareTo(o2.getBirth());
    }
}
