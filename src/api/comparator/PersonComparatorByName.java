package api.comparator;

import api.Person;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person>
{
    public int compare(Person p1, Person p2)
    {
        return p1.getName().compareTo(p2.getName());
    }
}
