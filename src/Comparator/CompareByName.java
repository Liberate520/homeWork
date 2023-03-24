package Comparator;

import java.util.Comparator;

import model.Person;

public class CompareByName implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
    
}
