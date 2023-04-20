package familyTree.comparators;

import familyTree.member.Human;

import java.util.Comparator;

public class MemberComparatorByName implements Comparator<Human> {


    @Override
    public int compare(Human o1, Human o2) {

        return o1.getName().compareTo(o2.getName());
    }


}
