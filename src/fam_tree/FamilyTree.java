package fam_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private final List<Human> humanList = new ArrayList<>();
    private int humanId = 1;

    public static void sortByName() {
    }

    public static void sortByAge() {
    }

    public static void sortById() {
    }

    public void addFamilyTree(Human human) {
        if (!humanList.contains(human)) {
            human.setId(humanId++);
            humanList.add(human);
            addToParrents(human);
            addToChildren(human);
        }}
    public void addToParrents(Human human){
        for (Human parent: human.getParrent()){
            parent.addChildren(human);
        }
    }
    public void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }

    public String familyTreeInfo () {
        StringBuilder sb = new StringBuilder();
        for (Human human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
