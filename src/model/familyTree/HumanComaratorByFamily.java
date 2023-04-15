package model.familyTree;

import model.human.Human;

import java.util.Comparator;

public class HumanComaratorByFamily implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getFamily().compareTo(o2.getFamily());
    }


}