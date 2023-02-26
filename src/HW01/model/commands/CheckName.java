package HW01.model.commands;

import HW01.model.FamilyTree;

public class CheckName {

    private FamilyTree familyTree;

    public CheckName(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }
    public boolean getCheck (FamilyTree familyTree, String name){
        //        если имя найдено в базе то true иначе false
        return (familyTree.getPerson(name) != null);
    }
}
