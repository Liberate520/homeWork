package ru.gb.family_tree.family_tree.presenter;

import ru.gb.family_tree.family_tree.model.Service.Service;
import ru.gb.family_tree.family_tree.model.human.Gender;
import ru.gb.family_tree.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name,Gender gender, LocalDate bDate, LocalDate dDate) {
        service.addHuman(name,gender,bDate,dDate);
    }
    public void addHuman(String name, Gender gender,LocalDate bDate) {
        service.addHuman(name,gender,bDate);
    }

    public String getFamilyTree() {
        return service.getFamilyTree();
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public void sortByName() {
        service.sortByName();
    }

    public void saveTreeToFile() {
        service.save(service.getFamilytree());
    }

    public void loadTreeFromFile() {
        service.load();
    }

    public void createFamilyConnectionByID(int childID,int parentID) {
        service.createFamilyConnectionByID(childID,parentID);
    }


}
