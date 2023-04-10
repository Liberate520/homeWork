package familyTree.comparators;

import member.Human;

import java.util.Comparator;

public class IdComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getHumanList().indexOf(o1), o2.getId());
    }


}
