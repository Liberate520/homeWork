package ru.gb.family_tree.Presenter;

import ru.gb.family_tree.Model.Family.Service.Service;
import ru.gb.family_tree.Model.Family.Tree.FamilyTree;
import ru.gb.family_tree.View.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service<>();
    }

    public void Info(){
        service.printTree();
    }


    public void getByAge() {
        service.getByAge();
    }

    public void getByDateOfBirth() {
        service.getByDateOfBirth();
    }

    public void getByGender() {
        service.getByGender();
    }

    public void getByName() {
        service.getByName();
    }
}
