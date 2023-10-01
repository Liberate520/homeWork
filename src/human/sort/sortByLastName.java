package human.sort;

import human.Human;

import java.util.Comparator;

public class sortByLastName implements Comparator<Human> {
    public int compare(Human o1, Human o2) { return o1.getLstName().compareTo(o2.getLstName());}
}

