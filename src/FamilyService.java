import models.Human;
import models.Roles;
import models.familyTree.FamilyNode;
import models.familyTree.FamilyTree;

import static models.Gender.MALE;
import static models.Roles.FATHER;
import static models.Roles.MOTHER;

public class FamilyService {
    private final FamilyTree familyTree;

    public FamilyService(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void createNewFamily(Human human) {
        FamilyNode newFamily = new FamilyNode();
        if (human.gender().equals(MALE)) {
            newFamily.addMember(human, FATHER);
        } else newFamily.addMember(human, MOTHER);
        this.familyTree.addNode(newFamily);
    }

    public void addMemberToFamily(Human human, Human humanToAdd, Roles role) {
        FamilyNode node = this.findPrimaryFamilyOrNull(human);
        if (node != null) {
            node.addMember(humanToAdd, role);
        } else throw new RuntimeException("Primary Family not found for " + human);
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
}
