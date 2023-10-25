package human.comparators;

import human.Human;

import java.util.Comparator;

public class CompareByFullName implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        String fullName1 = o1.getFirstName() + o1.getLastName();
        String fullName2 = o2.getFirstName() + o2.getLastName();
        return fullName1.compareTo(fullName2);
    }
}
