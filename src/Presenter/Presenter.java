package Seminars_OOP.HW_7.src.Presenter;

import Seminars_OOP.HW_7.src.Model.FamilyTree;
import Seminars_OOP.HW_7.src.Model.Human;
import Seminars_OOP.HW_7.src.View.View;


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

    public String getHumanByName(String nameOfHuman) {

        return familyTree.getHumanByName(nameOfHuman).toString();
    }

    public void sortByAge(){
        familyTree.sortByAge();
    }

    public void sortByName(){
        familyTree.sortByName();
    }
}


