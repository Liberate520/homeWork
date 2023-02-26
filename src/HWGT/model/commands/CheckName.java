package HWGT.model.commands;

import HWGT.model.FamilyTree;

public class CheckName {
    private FamilyTree familyTree;
    public CheckName(FamilyTree familyTree){this.familyTree = familyTree;}
    public boolean getCheck (FamilyTree familyTree, String name){
        return (familyTree.getPerson(name)!=null);
    }
}
