package ru.home.familyTree.family_Tree;

import ru.home.familyTree.human.Human;
import java.util.List;
import java.util.ArrayList;

public class FamilyTree {
    private List<Human> humanList;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human){
        humanList.add(human);
        addToParents(human);
        addToChildren(human);
    }

    private void addToParents(Human human){
        for (Human parent: human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for (Human child: human.getChildren()) {
            child.addParent(human);
        }
    }
    public String getHumansInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human: humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
