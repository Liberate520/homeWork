package HW_2;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public List<Human> getHumanList() {
        return humanList;
    }

    public void setHumanList(List<Human> humanList) {
        this.humanList = humanList;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Human item : humanList) {
            sb.append(item.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void addHuman(Human human) {
        if (!humanList.contains(human)) {
            humanList.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if (human.getMother() != null){
                human.getMother().addChild(human);
            }
        }
    }

    public Human getByName (String name){
        for (Human human: humanList){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }
}