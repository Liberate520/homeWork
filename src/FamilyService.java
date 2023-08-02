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

//        FamilyNode parentFamily = this.findPrimaryFamilyOrNull(human);
//        if (parentFamily != null) {
//            switch (human.gender()) {
//                case MALE -> newFamily.addToUpRelatives(FATHER, parentFamily);
//                case FEMALE -> newFamily.addToUpRelatives(MOTHER, parentFamily);
//            }
//        }
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

        this.updateFamilyNodes(node, nodeToAdd, role);
    }

    private void updateFamilyNodes(FamilyNode targetNode, FamilyNode nodeToAdd, Roles role) {
        switch (role) {
            case FATHER -> targetNode.addToUpRelatives(FATHER, nodeToAdd);
            case MOTHER -> targetNode.addToUpRelatives(MOTHER, nodeToAdd);
            case DAUGHTER -> targetNode.addToChildrenFamilies(DAUGHTER, nodeToAdd);
            case SON -> targetNode.addToChildrenFamilies(SON, nodeToAdd);
        }
    }

    public void delMemberFromFamily(Human human, Human humanToDel, Roles role) {
        FamilyNode node = this.findPrimaryFamilyOrNull(human);
        if (node != null) {
            node.delMember(humanToDel, role);
        } else throw new RuntimeException("Primary Family not found for " + human);
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
}
