package Package.Model.Iteration;

import Package.Model.Tree.Person;

import java.util.Comparator;

public class ComparatorBySurname<E extends Person> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
