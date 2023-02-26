package HWGT.model.commands;

import HWGT.model.FamilyTree;

public class SortByName {
    private FamilyTree familyTree;
    public SortByName(FamilyTree familyTree){this.familyTree = familyTree;}
    public void getSort(FamilyTree familyTree) {
        familyTree.sortByBirth();
    }
}
