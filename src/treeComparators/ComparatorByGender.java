package treeComparators;

import enums.Gender;
import treeWorkspace.Person;

import java.util.Comparator;

public class ComparatorByGender implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if (p1.getGender().equals(p2.getGender())){
            return 0;
        }else if (p1.getGender().equals(Gender.Male)
                && p2.getGender().equals(Gender.Female)){
            return 1;
        }
        return -1;
    }
}
