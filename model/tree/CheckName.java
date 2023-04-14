package model.tree;

import human.Human;

public class CheckName {
    private FamilyTree<Human> familyTree;

    public CheckName(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public boolean checkName(FamilyTree<Human> familyTree, String name) {
        return familyTree.getByName(name) != null;

    }
}
