package HW01.model.commands;

import HW01.model.FamilyTree;
import HW01.model.Repo;

import java.io.IOException;
import java.io.Serializable;

public class LoadData {
    private FamilyTree familyTree;

    public LoadData(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree doIt (FamilyTree familyTree) throws IOException, ClassNotFoundException {
        Repo repo1 = new Repo();
        familyTree = (FamilyTree) repo1.read("familyTree.out");
        System.out.println("база данных загружена \n");
        return familyTree;
    }
}
