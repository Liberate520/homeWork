package tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> humanList;
    public FamilyTree() {
        this(new ArrayList<>());
    }
    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void add(Human human) {
        if (human != null && getNameByName(human.getName()) == "none") {
            if (!humanList.contains(human) && !getNameByName(human.getName()).equals(human.getName())) {
                humanList.add(human);
                if (human.getFather() != null && !getNameByName(human.getFather().getName()).equals(human.getFather().getName())) {
                    humanList.add(human.getFather());
                    getByName(human.getFather().getName()).setChild(human);
                }
                if (human.getMother() != null && !getNameByName(human.getMother().getName()).equals(human.getMother().getName())) {
                    humanList.add(human.getMother());
                    human.getMother().setChild(human);
                }
            }
        }
    }


    public Human getByName (String name) {
        for (Human human: humanList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public String getNameByName (String name) {
        for (Human human: humanList) {
            if (human.getName().equals(name)) {
                return human.getName();
            }
        }
        return "none";
    }

    public String fullTree () {
        String ft = new String();
        for (Human human: humanList) {
            ft += human;
        }
        return ft;
    }
}
