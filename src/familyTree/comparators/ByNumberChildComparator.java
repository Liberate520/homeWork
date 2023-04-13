package familyTree.comparators;

import familyTree.member.Human;

import java.util.Comparator;

public class ByNumberChildComparator implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getNumChildren(), o2.getNumChildren());
    }

//    @Override
//    public int compare(Human o1, Human o2) {
//        int count1 = o1.getChildren().size();
//        int count2 = o2.getChildren().size();
//        return count1 - count2;
//    }


}
