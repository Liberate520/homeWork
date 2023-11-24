package com.ag.family_tree;

public class Main {
    public static void main(String[] args) {
        Human grandfather = new Human("grandFather","male", 1990, 1990);

        com.ag.family_tree.FamilyTree familyTree = new com.ag.family_tree.FamilyTree();
        familyTree.addParents(grandfather);

        System.out.println(familyTree);
    }
}