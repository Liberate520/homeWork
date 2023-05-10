package Presenter;

import model.Service;
import view.View;

public class Presenter {
    private Service service;
    private View view;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

    public void getFamilyTreeInfo() {
        this.service.getFamilyTreeInfo();
    }

    public void addNewHumanToFamilyTree() {
        this.service.addNewHumanToFamilyTree();
    }

    public void writeFamilyTreeInFile(String path) {
        this.service.writeFamilyTreeInFile(path);
    }

    public void readFamilyTreeFromFile(String path){

    }
}
