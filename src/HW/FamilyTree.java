package HW;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    public void addPerson(Human human) {
        humanList.add(human);
    }

    public void addAsChild(Human human) {
        this.addPerson(human);
        if (human.getFather() != null) {
            human.getFather().setChildren(human);
        }
        if (human.getMother() != null) {
            human.getMother().setChildren(human);
        }

    }
    public Human findPerson(String name,String surname) {
        for (Human human : humanList) {
            if (human.getName().equals(name) && human.getSurname().equals(surname)) {
                return human;
            }
        }
        return null;
    }

}
