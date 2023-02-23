import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person> {

    @Override
    public int compare(Person per1, Person per2) {
        return per1.getName().compareTo(per2.getName());
    }
}
