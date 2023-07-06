package FamilyTree.sort;

import FamilyTree.tree.Person;

import java.util.Comparator;

public class AgeComparator implements Comparator <Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getBirthday().isBefore(o2.getBirthday())) {
            return 1;
        }
        if (o1.getBirthday().isAfter(o2.getBirthday())) {
            return -1;
        }
        return 0;
    }
}