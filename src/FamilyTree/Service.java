package FamilyTree;

import FamilyTree.FamilyTree.FamilyTree;

public class Service {
    private FamilyTree familyTree;

//    public Service() {
//        familyTree = new FamilyTree();
//    }

    public Service(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void sortByAge() {
        familyTree.sortByAge();
    }

    public void sortByName() {
        familyTree.sortByName();
    }
}
