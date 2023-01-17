package model.allcommands;

import model.treeWork.FamilyTree;

import java.io.IOException;


public class WriteFiles implements Option {

    FamilyTree familyTree;


    public  void save() throws IOException {
        familyTree.write();
    }


    @Override
    public void execute() {
        try {
            familyTree.write();
        } catch (IOException e) {
            
            e.printStackTrace();
        }

    }

    @Override
    public String discription() {
        return "Записать в файл ";
    }



}
