package model.allcommands;

import model.treeWork.FamilyTree;

public class SortByName implements Option{


    FamilyTree familyTree;


   

    @Override
    public void execute() {
        familyTree.sortingByName();

    }

    @Override
    public String discription() {
        return "Сортировка по имени";
    }

}




