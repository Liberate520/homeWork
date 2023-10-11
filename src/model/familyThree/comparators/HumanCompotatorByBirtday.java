package model.familyThree.comparators;

import model.human.Human;

import java.util.Comparator;

public class HumanCompotatorByBirtday implements Comparator<Human> {

    @Override
    public int compare(Human human1, Human human2) {
        human1.getBirthday().compareTo( human2.getBirthday() );
        return 0;
    }
}
