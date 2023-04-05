package tree;

import java.io.Serializable;
import java.util.ArrayList;

public class FamilyTree implements Serializable {
    private final ArrayList<Human> famTree = new ArrayList<>();

    public void addHuman(Human human) {
        famTree.add(human);
        if (human.getMother() != null)
            human.getMother().addChild(human);

        if (human.getFather() != null)
            human.getFather().addChild(human);
    }

    public String findHuman(String name) {
        for (Human human : famTree)
            if (human.getName().contains(name)) {
                return human.toString();
            }
        return null;
    }

    @Override
    public String toString() {
        return famTree.toString();
    }


}