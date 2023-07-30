package Home_work.Family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import Home_work.Human.Human;

public class Family_tree implements Serializable{
    private List<Human> humanList;

    public Family_tree() {
        humanList = new ArrayList<>();
    }

    public Family_tree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void addTree(Human human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human);
                
            }

            if (human.getMother() != null) {
                human.getFather().addChild(human);
            }
        }
    }

    public String getInfo() {
        StringBuilder s = new StringBuilder();
        s.append(humanList.size());
        s.append(" Person \n");
        for (Human human : humanList) {
            s.append(human.getInfoHuman());
            s.append("\n");
        }
        return s.toString();
    }


    @Override
    public String toString() {
        return getInfo();
    }
}
