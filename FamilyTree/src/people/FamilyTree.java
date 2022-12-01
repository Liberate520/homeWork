package people;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    List<FamilyTree> familyTrees;

    /**
     * Метод конструктора
     * @param familyTrees список генеалогического древа
     */
    public FamilyTree(List<FamilyTree> familyTrees) {
        this.familyTrees = familyTrees;
    }

    /**
     * Метод для добавления разных людей
     */
    public FamilyTree(){
        this(new ArrayList<>());
    }

    public List<FamilyTree> getFamilyTrees() {
        return familyTrees;
    }

    public void setFamilyTrees(List<FamilyTree> familyTrees) {
        this.familyTrees = familyTrees;
    }
}
