package java_oop_homeWork.src;

import java_oop_homeWork.src.familyTree.FamilyTree;

import java.util.HashSet;

public class Service {
    private int id;
    private HashSet<FamilyTree> familyTrees;

    public void addFamilyTree(FamilyTree familyTree) {
        this.familyTrees.add(familyTree);
    }

}
