package HWGT.model.commands;

import HWGT.model.FamilyTree;

public class SortByBirth {
    private FamilyTree familyTree;
    public SortByBirth(FamilyTree familyTree){this.familyTree = familyTree;}
    public void getSort(FamilyTree familyTree){
        familyTree.sortByBirth();
    }
}
