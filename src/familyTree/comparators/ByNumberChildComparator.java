package familyTree.comparators;

import member.Human;

import java.util.Comparator;

public class ByNumberChildComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getNumChildren(), o2.getNumChildren());
    }

}
