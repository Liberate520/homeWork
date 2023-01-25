package Seminars_OOP.HW_6.src.Presenter;

import Seminars_OOP.HW_6.src.Model.FamilyTree;
import Seminars_OOP.HW_6.src.Model.Human;
import Seminars_OOP.HW_6.src.View.View;


public class Presenter<T extends Human>{
    View view;
    FamilyTree familyTree;

    public Presenter(View view, FamilyTree familyTree) {
        this.view = view;
        this.familyTree = familyTree;

    }
    public String getAllHuman(){

        return familyTree.getAllHuman().toString();

    }

    public void getHumanByName(String nameOfHuman) {

        familyTree.getHumanByName(nameOfHuman);
    }

}


