package homeWork.src.presenter;

import homeWork.src.FamilyTree;
import homeWork.src.Human;

public class Presenter<T extends Human> {

    private FamilyTree familyTree;

    public Presenter(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }


    public void setFamilyTree(FamilyTree familyTree) {
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

    public FamilyTree sortFamilyTree(String sortParameter) {
        familyTree.sortFamilyTree(sortParameter);
        return familyTree;
    }

//    public void saveJsonFile(FamilyTree familyTree){
//        Gson gson = new Gson();
//
//    }

}
