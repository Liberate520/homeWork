package family_tree.person.comparator;

import family_tree.person.Person;

import java.util.Comparator;

public class PersonComparatorByChildren implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getChildren().size(), o2.getChildren().size());
    }
}
