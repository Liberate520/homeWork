package familyTree;

import java.util.Comparator;

class ComparatorByBirthDate<E extends commonParam> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        if (Integer.compare(o1.getBirthDate(), o2.getBirthDate()) == 0) {
            return o1.getName().compareTo(o2.getName());
        } else {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
    }
}
