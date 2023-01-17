package model.allcommands;

import model.treeWork.FamilyTree;

public class FindByName implements Option {

    FamilyTree familyTree;
    
   String name;

    public FindByName(String name){

        this.name= name;
    }






    public void finbyName(String name) {

        familyTree.findByName(name).toString();
    }

    @Override
    public void execute() {


    }

    @Override
    public String discription() {
        return "Поиск по объекта древа по имени";
    }

}
