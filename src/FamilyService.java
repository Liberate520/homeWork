import models.Human;
import models.Roles;
import models.familyTree.FamilyNode;
import models.familyTree.FamilyTree;

import java.util.List;

import static models.Roles.*;

public class FamilyService {
    private final FamilyTree familyTree;

    public FamilyService(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyNode createNewFamily(Human human) {
        FamilyNode newFamily = new FamilyNode();
        switch (human.gender()) {
            case MALE -> newFamily.addMember(human, FATHER);
            case FEMALE -> newFamily.addMember(human, MOTHER);
        }
        this.familyTree.addNode(newFamily);
        return newFamily;
    }

    public void deleteFamily(Human human) {
        FamilyNode family = this.findPrimaryFamilyOrNull(human);
        familyTree.delNode(family);
    }

    public void addMemberToFamily(Human human, Human humanToAdd, Roles role) {
        FamilyNode node = this.findPrimaryFamilyOrNull(human);
        if (node != null) {
            node.addMember(humanToAdd, role);
        } else throw new RuntimeException("Primary Family not found for " + human);

        FamilyNode nodeToAdd = this.findPrimaryFamilyOrNull(humanToAdd);
        if (nodeToAdd == null) {
            nodeToAdd = this.createNewFamily(humanToAdd);
        }

        this.updateFamilyNodesAdd(node, nodeToAdd, role);
    }

    private void updateFamilyNodesAdd(FamilyNode targetNode, FamilyNode nodeToAdd, Roles role) {
        switch (role) {
            case FATHER -> this.setUpRelatives(targetNode, nodeToAdd, FATHER);
            case MOTHER -> this.setUpRelatives(targetNode, nodeToAdd, MOTHER);
            case DAUGHTER -> this.setRelativesToChildren(targetNode, nodeToAdd, DAUGHTER);
            case SON -> this.setRelativesToChildren(targetNode, nodeToAdd, SON);
        }
    }

    private void setUpRelatives(FamilyNode targetNode, FamilyNode nodeToAdd, Roles role) {
        FamilyNode parentNode = null;
        switch (role) {
            case FATHER -> parentNode = this.findPrimaryFamilyOrNull(nodeToAdd.getFather());
            case MOTHER -> parentNode = this.findPrimaryFamilyOrNull(nodeToAdd.getMother());
        }
        if (parentNode != null && !parentNode.getUpRelatives().isEmpty()) {
            targetNode.addToUpRelatives(role, parentNode);
        }
    }

    private void setRelativesToChildren(FamilyNode targetNode, FamilyNode nodeToAdd, Roles role) {
        targetNode.addToChildrenFamilies(role, nodeToAdd);

        FamilyNode fatherNode = this.findPrimaryFamilyOrNull(targetNode.getFather());
        FamilyNode motherNode = this.findPrimaryFamilyOrNull(targetNode.getMother());

        nodeToAdd.addToUpRelatives(FATHER, fatherNode);
        nodeToAdd.addToUpRelatives(MOTHER, motherNode);
    }

    public void delMemberFromFamily(Human human, Human humanToDel, Roles role) {
        FamilyNode node = this.findPrimaryFamilyOrNull(human);
        if (node != null) {
            node.delMember(humanToDel, role);
        } else throw new RuntimeException("Primary Family not found for " + human);

        FamilyNode nodeToExclude = this.findPrimaryFamilyOrNull(humanToDel);

        if (nodeToExclude != null) {
            this.updateFamilyNodesDel(node, nodeToExclude, role);
        }
    }

    private void updateFamilyNodesDel(FamilyNode targetNode, FamilyNode nodeToAdd, Roles role) {
        switch (role) {
            case FATHER -> targetNode.delFromRelatives(FATHER, nodeToAdd);
            case MOTHER -> targetNode.delFromRelatives(MOTHER, nodeToAdd);
            case DAUGHTER -> targetNode.delFromChildrenFamilies(DAUGHTER, nodeToAdd);
            case SON -> targetNode.delFromChildrenFamilies(SON, nodeToAdd);
        }
    }

    public void printPrimaryFamily(Human human) {
        System.out.println(this.findPrimaryFamilyOrNull(human).toString());
    }

    private FamilyNode findPrimaryFamilyOrNull(Human human) {
        FamilyNode node = null;
        switch (human.gender()) {
            case MALE -> node = familyTree.findFamilyOrNull(human, FATHER);
            case FEMALE -> node = familyTree.findFamilyOrNull(human, MOTHER);
        }
        return node;
    }

    public List<Human> getChildren(Human human) {
        FamilyNode family = this.findPrimaryFamilyOrNull(human);
        return family.getChildren();
    }

    public List<Human> getParents(Human human){
        FamilyNode family = this.findPrimaryFamilyOrNull(human);
        return family.getParents();
    }
}
