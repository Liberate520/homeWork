package model.tree;

import human.Human;

public class Check {
    private FamilyTree<Human> humanList;

    public Check(FamilyTree<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean checkname(FamilyTree<Human> humanList, String name) {

        return humanList.getByName(name) != null;

    }
}
