package familyTree.comparators;

import familyTree.member.Human;

import java.util.Comparator;

public class MemberComparatorByName implements Comparator<Human> {


    @Override
    public int compare(Human o1, Human o2) {

        return o1.getName().compareTo(o2.getName());
    }

    //    @Override
//    public int compare(Human o1, Human o2) {
//        int result = o1.getSurname().compareTo(o2.getSurname());
//        if (result == 0) {
//            result = o1.getName().compareTo(o2.getName());
//        }
//        return result;
//    }
}
