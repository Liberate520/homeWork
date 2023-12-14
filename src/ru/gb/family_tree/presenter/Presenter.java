package ru.gb.family_tree.presenter;


import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        service = new Service();
        this.view = view;
    }

    public void add(String name, String gender, String birthDate, long idFather, long idMother) {
        String answer = service.add(name, gender, birthDate, idFather, idMother);
        view.print(answer);
    }

    public void getHumanList() {
        String answer = service.getHumanList();
        view.print(answer);
    }
}