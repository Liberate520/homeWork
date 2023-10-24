package FamilyTree.Person.comparators;

import FamilyTree.Person.Person;

import java.time.LocalDate;
import java.util.Comparator;

public class CompareByPersonAge implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(LocalDate.from(o1.getBurnData()).getYear(), LocalDate.from(o2.getBurnData()).getYear());
    }
}
