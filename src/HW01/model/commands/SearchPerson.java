package HW01.model.commands;

import HW01.model.FamilyTree;

import java.util.Scanner;

public class SearchPerson {

    private FamilyTree familyTree;
//    private CheckName checkName;

    public SearchPerson(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void getPerson(FamilyTree familyTree, String nameForSearch) {
        CheckName checkName = new CheckName(familyTree);
        if (checkName.getCheck(familyTree, nameForSearch)) {
            System.out.println(familyTree.getPerson(nameForSearch));
        } else {
            System.out.println("человек с таким именем не найден");
        }
    }
}

