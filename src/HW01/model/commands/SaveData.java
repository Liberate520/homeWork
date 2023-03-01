package HW01.model.commands;

import HW01.model.FamilyTree;
import HW01.model.Repo;

import java.io.IOException;
import java.io.Serializable;

public class SaveData {
    private FamilyTree familyTree;

    public SaveData(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void doIt (FamilyTree familyTree) throws IOException {
        Repo repo1 = new Repo();
        repo1.save((Serializable) familyTree, "familyTree.out");
        System.out.println("база данных сохранена \n");
    }
}
