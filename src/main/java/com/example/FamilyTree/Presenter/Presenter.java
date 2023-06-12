package com.example.FamilyTree.Presenter;

import com.example.FamilyTree.DataForTree.Family;
import com.example.FamilyTree.DataForTree.FamilyTree;
import com.example.FamilyTree.DataForTree.Gender;
import com.example.FamilyTree.Model.Model;
import com.example.FamilyTree.View.View;

import java.io.File;

public class Presenter {
    private View view;
    private Model model;
    private boolean work = true;

    public Presenter() {
        view = new View();
        model = new Model();
    }

    public void RunFamilyTree(){
        String objectSelection = view.ObjectSelection();
        FamilyTree<Family> familyTree = new FamilyTree<>();

        String path = "./src/main/java/com/example/FamilyTree/FamilyTree"+objectSelection+".txt";
        File file = new File(path);
        if (!file.exists()) {
            familyTree = model.getFamilyTree(objectSelection, path);
            if (!familyTree.getObjectFamilyList().isEmpty()) {
                model.FileProcessing(1, familyTree, path);
            }
        } else {
            familyTree = (FamilyTree<Family>) model.FileProcessing(2, familyTree, path);
        }
        if (familyTree.getObjectFamilyList().isEmpty()) {
            familyTree = view.addFamilyTree(objectSelection, familyTree);
            if (!familyTree.getObjectFamilyList().isEmpty()) {
                model.FileProcessing(1, familyTree, path);
            }
        }

        if (!familyTree.getObjectFamilyList().isEmpty()) {
            System.out.println("Общий список лиц семьи: ");
            System.out.println(familyTree.printObjectList());

            System.out.println("Сортировка по дню рождения: ");
            familyTree.sortByBirthday();
            System.out.println(familyTree.printObjectList());

            System.out.println("Сортировка по имени: ");
            familyTree.sortByName();
            System.out.println(familyTree.printObjectList());

            familyTree = view.addFamilyTree(objectSelection, familyTree);
            model.FileProcessing(1, familyTree, path);

            String answer = "0";
            do {
                answer = view.MenuAction(familyTree);
                if (!answer.equals("0")) {
                    model.filterFamilyTree(answer, familyTree);
                }
            } while (!answer.equals("0"));
        } else {
            System.out.println("Семейное дерево "+objectSelection+" пустое");
        }
    }
}
