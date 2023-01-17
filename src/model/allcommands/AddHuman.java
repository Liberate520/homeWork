package model.allcommands;

import model.treeWork.FamilyTree;
import model.treeWork.Human;

public class AddHuman implements Option{


    private FamilyTree<Human> familyTreeHuman;

   private Human human;

    public AddHuman(Human human) {
    }
    public AddHuman() {

       
    }


    @Override
    public void execute() {
        familyTreeHuman.addElement(human);

    }

    @Override
    public String discription() {
        return "Добавить в древо Человека";
    }


}

