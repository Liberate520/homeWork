package model.familyThree.comparators;

import model.human.Human;

import java.util.Comparator;

public class HumanCompotatorByName implements Comparator<Human> {

    @Override
    public int compare(Human human1, Human human2) {
        human1.getFirstName().compareTo( human2.getFirstName() );
        return 0;
    }
}
