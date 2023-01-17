package model.allcommands;

import model.treeWork.ElementTree;
import model.treeWork.FamilyTree;
import model.treeWork.Human;

import java.io.IOException;


public class ReadFiles <T extends ElementTree> implements Option{

    private FamilyTree<T> familyTreeHuman;

   

    @Override

    public void execute() {
        try {
            familyTreeHuman.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    
    }

    @Override
    public String discription() {
        return "Открыть  файл ";
    }

}
