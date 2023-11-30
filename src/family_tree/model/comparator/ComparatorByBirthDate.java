package family_tree.model.comparator;

import family_tree.model.human.Human;

import java.util.Comparator;

public class ComparatorByBirthDate implements Comparator<Human> {

    //    public int compare(Human o1, Human o2) {
//        return o1.getBirthDate().compareTo(o2.getBirthDate());
//    }
    public int compare(Human o1, Human o2) {
        ComparatorByBirthDate comparator = new ComparatorByBirthDate();
        int compareResultAge = comparator.compare(o1, o2);
        System.out.println("compareResult: " + compareResultAge);
        return compareResultAge;
    }

    public static void main(String[] args){


    }




}
