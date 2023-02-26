package HWGT.model.commands;

import HWGT.model.FamilyTree;

public class SearchPerson {
    private FamilyTree familyTree;
    public SearchPerson(FamilyTree familyTree){this.familyTree = familyTree;}
    public void getPerson(FamilyTree familyTree, String nameForSearch){
        CheckName checkName = new CheckName(familyTree);
        if (checkName.getCheck(familyTree, nameForSearch)){
            System.out.println(familyTree.getPerson(nameForSearch));
        }
        else {
            System.out.println("Человек с таким именем не найден");
        }
    }

}
