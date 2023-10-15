package ru.gb.family_tree.Presenter;

import ru.gb.family_tree.Model.Family.Service.Service;
import ru.gb.family_tree.Model.Family.Tree.FamilyTree;
import ru.gb.family_tree.View.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void info(){
        String info = service.sortInfoTree();
        view.printAnswer(info);
    }


    public void getByAge() {
        service.sortByAge();
        info();
    }

    public void getByDateOfBirth() {
        service.sortByDateOfBirth();
        info();
    }

    public void getByGender() {
        service.sortByGender();
        info();
    }

    public void getByName() {
        service.sortByName();
        info();
    }
}
