package person;

import java.util.Comparator;

public class ComparatorGender implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getGender(),o2.getGender());
    }
}