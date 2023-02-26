package HW01.model.commands;

import HW01.model.FamilyTree;

public class SortByName {

    private FamilyTree familyTree;

    public SortByName(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void getSort(FamilyTree familyTree){
        familyTree.sortByName();

    }
}
