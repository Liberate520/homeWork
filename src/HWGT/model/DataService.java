package HWGT.model;

import java.io.IOException;
import java.io.Serializable;

public class DataService {

    private FamilyTree familyTree;
    private PrintService printService = new PrintService(familyTree);

    public DataService(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public FamilyTree LoadData() throws IOException, ClassNotFoundException {
        Repo repo1 = new Repo();
        familyTree = (FamilyTree) repo1.read("familyTree.out");
        System.out.println("База данных загружена \n");
        return familyTree;
    }



    public void saveData() throws IOException {
        Repo repo1 = new Repo();
        repo1.save((Serializable) familyTree, "familyTree.out");
        System.out.println("база данных сохранена \n");
    }
}
