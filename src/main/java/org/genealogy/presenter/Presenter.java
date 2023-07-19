package org.genealogy.presenter;

import org.genealogy.model.service.Service;
import org.genealogy.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String firstName, String lastName) {
        service.addHuman(firstName, lastName);
        getHumanListInfo();
    }

    public void getHumanListInfo() {
        String info = service.getTreeInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        service.sortByAge();
        getHumanListInfo();
    }

    public void sortByName() {
        service.sortByName();
        getHumanListInfo();
    }

    public void addDateOfBirth(int id, int day, int month, int year) {
        service.addDateOfBirth(id, day, month, year);
        getHumanListInfo();
    }
}
