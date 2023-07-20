package Presenter;

import Model.FamilyTreeObject.FamilyTreeObject;
import Model.FamilyTreeService;
import View.View;

public class Presenter {
    private FamilyTreeService familyTreeService;
    private View view;

    public Presenter(FamilyTreeService familyTreeService, View view){
        this.familyTreeService = familyTreeService;
        this.view = view;
        view.setPresenter(this);
    }

    public String addElement(String name, String surname, String gender){

        return familyTreeService.addElement(name, surname, gender);
    }
    public String deleteObject(String name, String surname){
        if(familyTreeService.deleteElement(name, surname)){
            return "Удаление прошло успешно!";
        }
        return "Удаление не удалось!";
    }
    public FamilyTreeObject getElement(String name, String surname){
        return  familyTreeService.getElement(name, surname);


    }


    public String addParent(FamilyTreeObject familyTreeObject, String name, String surname, String gender){
        return familyTreeService.addParent(familyTreeObject,name, surname, gender);
    }

    public String addChildren(FamilyTreeObject familyTreeObject, String name, String surname, String gender){
        return familyTreeService.addChildren(familyTreeObject, name, surname, gender);

    }
    public String getElementInfo(String name, String surname){
        return familyTreeService.getElementInfo(name, surname);
    }
    public String allObjectInfo(){
        return familyTreeService.elemensPrint();
    }

}
