package comparators;

import java.util.Comparator;

public class TreeComparatorByDOB implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}
