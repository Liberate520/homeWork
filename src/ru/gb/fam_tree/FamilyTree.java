package ru.gb.fam_tree;

import ru.gb.fam_tree.human.Human;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Human> familyTree;

    public FamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void addHuman(Human human) {
        familyTree.add(human);
    }

    public List<String> getChildrensNames(Human parentHuman){
        List<String> res = new ArrayList<>();
        for(Human i: parentHuman.getChildrens()) {
            res.add(i.getFirstName());
        }
        return res;
    }
}
