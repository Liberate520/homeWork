package Package.Model.Iteration;

import Package.Model.Tree.Person;

import java.util.Comparator;

public class ComparatorByBirthdate <E extends Person> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
