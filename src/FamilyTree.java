package Homeworks.homeWork.src.main.java;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> familyTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public void addHuman(Human human) {
        this.familyTree.add(human);
    }

    public String showFamilyTree(){
        StringBuilder sb = new StringBuilder();
        for (Human i: familyTree) {
            sb.append(i.toString() + "\n");
        }
        return sb.toString();
    }


}
