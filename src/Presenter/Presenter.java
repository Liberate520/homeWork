package Presenter;

import Model.FamilyTree.FamilyTree;
import Model.FamilyTreeObject.FamilyTreeObject;
import View.View;

public class Presenter {
    private FamilyTree familyTree;
    private View view;
    private FamilyTreeObject familyTreeObject;

    public Presenter(FamilyTree familyTree, View view){
        this.familyTree = familyTree;
        this.view = view;
        view.setPresenter(this);
    }

    public void addObject(String name, String surname, String gender){

        familyTree.addElement(name, surname, gender);
    }
    public Boolean deleteObject(String name, String surname){
        return familyTree.deleteElement(name, surname);
    }
    public FamilyTreeObject getObject(String name, String surname){
        return familyTreeObject = familyTree.getElement(name, surname);


    }


    public void addParent(FamilyTreeObject familyTreeObject, String name, String surname, String gender){

        if(gender.equals("male")){
            familyTreeObject.setFather(new FamilyTreeObject(name,surname,gender));
        }
        else{familyTreeObject.setMother(new FamilyTreeObject(name,surname,gender));}
    }
    public String objectInfo(String name, String surname){
        return familyTree.getElement(name, surname).toString();
    }
    public String allObjectInfo(){
        return familyTree.elemensPrint();
    }

}
