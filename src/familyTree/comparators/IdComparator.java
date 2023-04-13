package familyTree.comparators;

import familyTree.member.Human;

import java.util.Comparator;

public class IdComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }


}
