package ru.geekbrains.family_tree;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Семейное древо, отражающее отношения членов семьи.
 */
public class FamilyTree implements Serializable {

    /*
     * Члены семьи.
     */
    private ArrayList<Human> familyMembers;

    public FamilyTree(ArrayList<Human> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public void add(Human familyMember) {
        familyMembers.add(familyMember);
    }

    @Override
    public String toString() {
        return familyMembers.toString();
    }

}