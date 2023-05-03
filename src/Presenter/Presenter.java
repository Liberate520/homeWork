package Presenter;

import Services.Service;
import ui.View;

import java.io.IOException;

public class Presenter {
    protected View view;
    public Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public Presenter(Service service) {
        this.service = service;
        view.setPresenter(this);
    }

    public Presenter(View view) {
        this.view = view;
        view.setPresenter(this);
    }

    public void setView(View view) {
        this.view = view;
        view.setPresenter(this);
    }

    public void setService(Service service) {
        this.service = service;
        view.setPresenter(this);
    }

    public void printTree() {
        view.print(service.printTree().toString());
    }

    public void sortBySecondName() {
        view.print(service.sortBySecondName().toString());
    }

    public void loadTree() throws IOException, ClassNotFoundException {
        service.loadTree();
    }

    public void saveTree() throws IOException {
        service.saveTree();
    }

    public void sortBySex() {
        view.print(service.sortBySex().toString());
    }

    public void sortByBirthYear() {
        view.print(service.sortByYear().toString());
    }

    public void addHuman(String birthDay, String firstName, String secondName, String patronymic, String sex) {
        String answer = service.addHuman(birthDay, firstName, secondName, patronymic, sex);
        view.print(answer);
    }

}

