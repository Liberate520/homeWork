package people;

import java.util.ArrayList;

public class FamilyTree {
    String familyTrees;

    /**
     * Метод конструктора
     * @param familyTrees список генеалогического древа
     */
    public FamilyTree(String familyTrees) {
        this.familyTrees = familyTrees;
    }

    public String getFamilyTrees() {
        return familyTrees;
    }

    public void setFamilyTrees(String familyTrees) {
        this.familyTrees = familyTrees;
    }
}
