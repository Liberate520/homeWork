import java.util.Comparator;

public class PersonCompareByYearOfReign implements Comparator<Person> {
    @Override
    public int compare(Person per1, Person per2) {
        return per1.getAdditionalField().compareTo(per2.getAdditionalField());
    }
}
