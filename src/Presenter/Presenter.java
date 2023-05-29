package Presenter;

import model.ModelService;
import model.human.Gender;
import view.View;

public class Presenter {
    private ModelService modelServiceservice;
    private View view;

    public Presenter(View view) {
        this.view = view;
        this.modelServiceservice = new ModelService();
    }

    public String getFamilyTreeInfo() {
       return this.modelServiceservice.getFamilyTreeInfo();
    }

    public void addNewHumanToFamilyTree(Gender gender, String name, String lastName, Integer age ) {
        this.modelServiceservice.addNewHumanToFamilyTree(gender, name, lastName, age);
    }

    public boolean writeFamilyTreeInFile(String path) {
        return this.modelServiceservice.writeFamilyTreeInFile(path);
    }

    public Integer getFamilyTreeSize() {
        return this.modelServiceservice.getFamilyTreeSize();
    }

    public Integer readFamilyTreeFromFile(String path){
        return this.modelServiceservice.readFamilyTreeFromFile(path);
    }

    public boolean deleteHumanFromFamilyTree(Integer id) {
        return this.modelServiceservice.deleteHumanFromFamilyTree(id);
    }
}
