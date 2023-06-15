package tree.model;

import tree.model.human.Gender;
import tree.model.human.Human;

import java.util.List;

import static tree.model.human.Gender.man;

public class AddHumanService {
    private List<Human> familyTry;

    public AddHumanService(List<Human> familyTry) {
        this.familyTry = familyTry;
    }

    public void addHuman(String name, Gender gender, String father, String mother) {
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

    public boolean removeHumanFromTree(String name) {
        Human human = findHuman(name);
        if (human != null) {
            familyTry.remove(human);
            return true;
        }
        return false;
    }

    public void addParent(String nameChild, String nameParent) {
        Human child = findHuman(nameChild);
        Human parent = findHuman(nameParent);
        if (child != null && parent != null) {
            if (parent.getGender() == man) {
                if (child.getFather() == null) {
                    child.setFather(parent);
                    parent.setChildren(child);
                } else {
                    System.out.printf("У %s уже есть отец %s\n", child.getName(), child.getFather().getName());
                }
            } else if (child.getMother() == null) {
                child.setMother(parent);
                parent.setChildren(child);
                } else {
                System.out.printf("У %s уже есть мать %s\n", child.getName(), child.getMother().getName());
            }
        } else {
            System.out.printf("Ребенок %s или Родитель %s отсутствует в дереве\n", nameChild, nameParent);
        }
    }

    private boolean containsHumanInTree(Human human) {
        return human != null && findHuman(human.getName()) != null;
    }

    private void addChildren(Human parent, Human child) {
        if (parent != null && child != null)
            parent.setChildren(child);
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
