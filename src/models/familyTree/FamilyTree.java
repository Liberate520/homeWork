package models.familyTree;

import models.Human;
import models.Roles;

import java.util.ArrayList;
import java.util.List;

// Семейное дерево
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

    public boolean contain(FamilyNode node) {
        return this.tree.contains(node);
    }

    public FamilyNode findFamilyOrNull(Human human, Roles role) {
        FamilyNode returnNode = null;
        for (FamilyNode familyNode : tree) {
            if (familyNode.checkHumanRole(human, role)) {
                returnNode = familyNode;
            }
        }
        return returnNode;
    }
}

