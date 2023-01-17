package model.allcommands;

import model.treeWork.ElementTree;
import model.treeWork.FamilyTree;

import java.util.List;

public class PrintAll implements Option {

  //  private FamilyTree<ElementTree> familyTreeHuman;;



    @Override
    public void execute() {
        FamilyTree work = new FamilyTree<>();
        work.printAllTree();




    }

    @Override
    public String discription() {
        return "Печать всех объектов древа";
    }

}
