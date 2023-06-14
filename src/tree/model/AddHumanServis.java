package tree.model;

import tree.model.human.Gender;
import tree.model.human.Human;

import java.util.List;

public class AddHumanServis {
    private List<Human> familyTry;

    public AddHumanServis(List<Human> familyTry) {
        this.familyTry = familyTry;
    }

    public void createHuman(String name, Gender gender, String father, String mother) {
        Human human, dad, mom;

        if (father.isEmpty()) {
            dad = null;
        } else {
            dad = new Human(father, Gender.man);
        }
        if (mother.isEmpty()) {
            mom = null;
        }else {
            mom = new Human(mother, Gender.woman);
        }

        human = new Human(name, gender, dad, mom);
        familyTry.add(human);

        if (containsHumanInTree(dad)) findHuman(dad.getName()).addChild(human);
        else addChildren(dad, human);
        if (containsHumanInTree(mom)) findHuman(mom.getName()).addChild(human);
        else addChildren(mom, human);

    }

    public void addParent() {
        /**
         * TO DO
         */
    }


    private boolean containsHumanInTree(Human human) {
        return human != null && findHuman(human.getName()) != null;
    }

    private void addChildren(Human parent, Human child) {
        if (parent != null && child != null)
            parent.addChild(child);
    }

    public Human findHuman(String name) {
        for (Human human : familyTry) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }


}
