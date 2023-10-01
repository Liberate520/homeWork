package human.sort;

import human.Human;

import java.util.Comparator;

public class sortByFirstName implements Comparator<Human> {
    public int compare(Human o1, Human o2) { return o1.getFstName().compareTo(o2.getFstName());}
}
