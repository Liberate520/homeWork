package HWGT.model.commands;

import HWGT.model.FamilyTree;
import HWGT.model.Repo;

import java.io.IOException;

public class LoadData {
    private FamilyTree familyTree;
    public LoadData(FamilyTree familyTree){this.familyTree = familyTree;}

    public FamilyTree doIt (FamilyTree familyTree) throws IOException, ClassNotFoundException {
        Repo repo1 = new Repo();
        familyTree = (FamilyTree) repo1.read("familyTree.out");
        System.out.println("База данных загружена \n");
        return familyTree;
    }

}
