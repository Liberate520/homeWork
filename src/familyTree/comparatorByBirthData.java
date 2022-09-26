package familyTree;


import HR.Human;

import java.util.Comparator;

class ComparatorByBirthDate implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        if (int.compare(o1.getBirthDate(), o2.getBirthDate()) == 0) {
            return o1.getName().compareTo(o2.getName());
        } else {
            return Integer.compare(o1.getAge(), o2.getAge());
        }
//        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
