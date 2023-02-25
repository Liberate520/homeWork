import java.util.Comparator;

public class PersonComparatorByDateOfBirth implements Comparator<Person>
{
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getYearOfBirth(), p2.getYearOfBirth());
    }
}
