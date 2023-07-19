package ru.geekbrains.family_tree;

import java.util.ArrayList;

/**
 * Семейное древо, отражающее отношения членов семьи.
 */
public class FamilyTree {

    /*
     * Члены семьи.
     */
    private ArrayList<Human> familyMembers;

    public FamilyTree() {
        familyMembers = new ArrayList<>();
    }

    public FamilyTree(ArrayList<Human> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public void add(Human familyMember) {
        familyMembers.add(familyMember);
    }

    @Override
    public String toString() {
        return familyMembers.toString();
    }
    
}