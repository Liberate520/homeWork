package tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> humanLs;
    public FamilyTree() {
        this(new ArrayList<>());

    }
    public FamilyTree(List<Human> humanLs){
        this.humanLs = humanLs;
    }
    public void add(Human human) {
        if (!humanLs.contains(human)){
            humanLs.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if (human.getMother() != null){
                human.getMother().addChild(human);
            }
        }

    }
    public Human getByName(String name){
        for (Human human: humanLs) {
            if (human.getName().equals(name)){
                return human;
            }

        }
        return null;
    }

    public String getInfo() {
        StringBuilder s = new StringBuilder();
        s.append(humanLs.size());
        s.append("объектов \n");
        for (Human human: humanLs){
            s.append(human.getInfo());
            s.append("\n");
        }
        return s.toString();
    }




}
