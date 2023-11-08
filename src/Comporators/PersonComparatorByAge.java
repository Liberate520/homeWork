package Comporators;

import Tree.Person;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Map;

public class PersonComparatorByAge implements Comparator<Map.Entry<Integer, Person>> {
    @Override
    public int compare(Map.Entry<Integer, Person> o1, Map.Entry<Integer, Person> o2) {
        return o2.getValue().getBirthDate().compareTo(o1.getValue().getBirthDate());
    }
}

