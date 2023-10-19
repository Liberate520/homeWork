package model.familyThree.comparators;

import model.familyThree.FamilyThreeElement;
import model.human.Human;

import java.util.Comparator;

public class HumanCompotatorByName<E extends FamilyThreeElement> implements Comparator<E> {

    @Override
    public int compare(E human1, E human2) {
        return human1.getFirstName().compareTo( human2.getFirstName() );
    }
}
