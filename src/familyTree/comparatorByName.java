package familyTree;

import HR.Human;

import java.util.Comparator;

class ComparatorByName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
