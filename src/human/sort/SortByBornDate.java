package human.sort;

import human.Human;

import java.util.Comparator;

public class SortByBornDate implements Comparator<Human> {
    public int compare(Human o1, Human o2) { return o1.getBornDate().compareTo(o2.getBornDate());}
}
