package presenter;


import java.io.Serializable;

import model.TreeService;
import ui.View;

public class Presenter {
    private View view;
    private TreeService tree;


    public Presenter(View view, TreeService tree) {
        this.view = view;
        this.tree = tree;
        view.setPresenter(this);
    }


    public void addHuman(String name, String surName, String fatherName, String mother, String father, String gender,
            int age) {
        tree.addHuman(name, surName, fatherName, mother, father, gender, age);
    }
    
    public void showInfo() {
        view.print(tree.showInfo());
   
    }

    public void removeHuman(String name, String surName, String fatherName) {
        tree.removeHuman(name, surName, fatherName);
    }

    public void showShortInfo() {
        view.print(tree.showShortTreeInfo());
    }

    public void showGenderStatistics(String gender) {
        view.print(tree.showGenderStatistics(gender));
    }

    public void save(String path) {
        tree.save(path, tree.getTree());
    }

    public void load(String path) {
        tree.load(path);
    }

    public int getTreeSize() {
        return tree.getTreeSize();
    }






}
