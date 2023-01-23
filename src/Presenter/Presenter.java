package Seminars_OOP.HW_5.src.Presenter;

import Seminars_OOP.HW_5.src.Model.FamilyTree;
import Seminars_OOP.HW_5.src.Model.Human;
import Seminars_OOP.HW_5.src.View.View;

public class Presenter {
    View view;
    FamilyTree familyTree;

    public Presenter(View view, FamilyTree familyTree) {
        this.view = view;
        this.familyTree = familyTree;

    }

    public void getHumanByName(String name) {
        FamilyTree.getHumanByName(name);
    }
}


