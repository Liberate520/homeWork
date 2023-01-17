package model.allcommands;

import model.treeWork.FamilyTree;

public class SortByAge implements Option{

    FamilyTree familyTree;


    


    @Override
    public void execute() {

        familyTree.sortingByAge();
    }

    @Override
    public String discription() {
        return "Сортировка по Возрасту";
    }


}

