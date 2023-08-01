package models.familyTree;

import models.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private final List<FamilyNode> tree;

    public FamilyTree() {
        this.tree = new ArrayList<>();
    }

    public void addNode(FamilyNode node) {
        tree.add(node);
    }

    public void delNode(FamilyNode node) {
        tree.remove(node);
    }

    public FamilyNode findFamilyOrNull(Human human){
        FamilyNode returnNode = null;
        for (FamilyNode familyNode : tree) {
            if (familyNode.findHuman(human)) {
                returnNode = familyNode;
            }
        }
        return returnNode;
    }
}

