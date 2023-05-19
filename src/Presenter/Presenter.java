package Presenter;

import model.Service;
import model.human.Gender;
import view.View;

public class Presenter {
    private Service service;
    private View view;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

    public String getFamilyTreeInfo() {
       return this.service.getFamilyTreeInfo();
    }

    public void addNewHumanToFamilyTree(Gender gender, String name, String lastName, Integer age ) {
        this.service.addNewHumanToFamilyTree(gender, name, lastName, age);
    }

    public void writeFamilyTreeInFile(String path) {
        this.service.writeFamilyTreeInFile(path);
    }

    public void readFamilyTreeFromFile(String path){

    }
}
