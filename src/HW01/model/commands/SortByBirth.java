package HW01.model.commands;

import HW01.model.FamilyTree;

public class SortByBirth {

    private FamilyTree familyTree;

    public SortByBirth(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void getSort(FamilyTree familyTree){
        familyTree.sortByBirth();
    }
}
