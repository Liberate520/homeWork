package human.sort;

import human.Human;

import java.util.Comparator;

public class SortByAge implements Comparator<Human> {
    public int compare(Human o1, Human o2) { return Integer.compare(o1.getAge(), o2.getAge());}
}
