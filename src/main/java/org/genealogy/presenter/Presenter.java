package org.genealogy.presenter;

import org.genealogy.model.person.Gender;
import org.genealogy.model.service.Service;
import org.genealogy.view.View;

import java.io.IOException;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String firstName, String lastName) throws IOException {
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

    public void addDateOfDeath(int id, int day, int month, int year) {
        service.addDateOfDeath(id, day, month, year);
        getHumanListInfo();
    }

    public void addGender(int id, Gender gender) {
        service.addGender(id, gender);
        getHumanListInfo();
    }

    public void addChild(int parentId, int childId) {
        service.addChildren(parentId, childId);
        getHumanListInfo();
    }

    public void saveTreeToFile() throws IOException {
        service.saveTreeToFile();
    }

    public void loadTreeFromFile() throws IOException, ClassNotFoundException {
        service.loadTreeFromFile();
    }
}
