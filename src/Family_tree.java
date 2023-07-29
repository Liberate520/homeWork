package OOP.Less_001.Home_work_less_01.Family_tree;

import java.util.ArrayList;
import java.util.List;

import OOP.Less_001.Home_work_less_01.Human.Human;

public class Family_tree {
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

    // public getAgeInfo(Integer birthdays){
    //     for (Human human : humanList) {
    //         if (human.getBirthdays().equals(birthdays)) {
    //             return human;
    //         }
            
    //     }
    //     return null;
    // }

    public Human getByName(String name) {
        for (Human human : humanList) {
            if (human.getName().equals(name)) {
                return human;
            }

        }
        return null;
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

}
