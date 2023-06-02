package comparers;

import java.util.Comparator;

import tree.Human;

/** компаратор по имени */
public class ComparatorFamilyByName implements Comparator<Human> {
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
