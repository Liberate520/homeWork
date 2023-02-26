package HWGT.model.commands;

import HWGT.model.FamilyTree;

public class PrintTree {
    private FamilyTree familyTree;
    public PrintTree(FamilyTree familyTree){
        this.familyTree = familyTree;
    }
    public void getFamilyTree (FamilyTree familyTree){
        for (Object pers:familyTree){
            System.out.println(pers);
        }
    }
}
