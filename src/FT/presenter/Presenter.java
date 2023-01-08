package FT.presenter;

import FT.Tree;
import FT.Human;

public class Presenter<T extends Human> {

    private Tree familyTree;

    public Presenter(Tree familyTree) {
        this.familyTree = familyTree;
    }


    public void setFamilyTree(Tree familyTree) {
        this.familyTree = familyTree;
    }

    public void saveFamilyTree() {
        familyTree.saveFamilyTree();
    }

    public void printFamilyTree() {
        System.out.println(familyTree);
    }

    public void addNewMember(T newHuman) {
        familyTree.addNewMember(newHuman);
    }

    public T findMember(String str) {
        return (T) familyTree.getByName(str);
    }

    public String getAllChildren(String str) {
        return familyTree.getByName(str).getAllChildren();
    }

    public String getAllSisters(String str) {
        return String.format("Сёстры %s - %s\n", familyTree.getByName(str).getName(), familyTree.getByName(str).getAllSistersOrBrothers("Ж"));
    }

    public String getAllBrothers(String str) {
        return String.format("Братья %s - %s\n", familyTree.getByName(str).getName(), familyTree.getByName(str).getAllSistersOrBrothers("М"));
    }

    public Tree sortFamilyTree(String sortParameter) {
        familyTree.sortFamilyTree(sortParameter);
        return familyTree;
    }

}
