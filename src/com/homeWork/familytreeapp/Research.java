package com.homeWork.familytreeapp;

import com.homeWork.familytreeapp.model.FamilyTree;
import com.homeWork.familytreeapp.model.GenealogicalTree;
import com.homeWork.familytreeapp.model.Human;
import com.homeWork.familytreeapp.presenter.FamilyTreePresenter;
import com.homeWork.familytreeapp.view.ConsoleUserInterface;

public class Research {
    public static void main(String[] args) {
        GenealogicalTree<Human> familyTree = new FamilyTree<>();
        Human parentTemplate = new Human("", 0, "");
        ConsoleUserInterface<Human> userInterface = new ConsoleUserInterface<>(parentTemplate);
        FamilyTreePresenter<Human> presenter = new FamilyTreePresenter<>(familyTree, userInterface);
        userInterface.run();
    }
}
