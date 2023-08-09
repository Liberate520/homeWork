package homeWork.ProjectFamilyTree.Model.Services;

import homeWork.ProjectFamilyTree.Model.Family_tree;

public class Sorting {
    private Family_tree familyTree;

    public Sorting() {
        familyTree = new Family_tree<>();
    }
    public void sortByAge(){familyTree.sortByAge();}
    public void sortByName(){familyTree.sortByName();}
}
