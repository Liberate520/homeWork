package faminly_tree.presenter;

import faminly_tree.model.human.Gender;
import faminly_tree.model.service.Service;
import faminly_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;
    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }
   /* public void addHuman(String name, Gender gender, LocalDate date) {
        service.addHuman(name, gender, date);
    }*/
    public void addHuman(){
        service.addHuman();
    }
    public void sortByAge() {
        service.sortByAge();
    }
    public void sortByName() {
        service.sortByName();
    }
    public void sortByID(){
        service.sortByID();
    }
    public void showAllTree() {
        service.showAllTree();
    }
    public boolean connection(int parentID, int childID) {
        return service.connection(parentID, childID);
    }
    public boolean save(String path) {
        return service.save(path);
    }
    public boolean downland(String path) {
        return service.dowland(path);
    }
    public void nextOfKin(int humanID) {
        service.nextOfKin(humanID);
    }
    public int treeIsEmpty(){
        return service.treeIsEmpty();
    }

    public void setHumanName(String name) {
        service.setHumanName(name);
    }

    public void setHumanPatronymic(String patronymic) {
        service.setHumanPatronymic(patronymic);
    }

    public void setHumanSurname(String surname) {
        service.setHumanSurname(surname);
    }

    public void addHumanToTree() {
        service.addHumanToTree();
    }

    public void setHumanBirth(LocalDate date) {
        service.setHumanBirth(date);
    }

    public void setHumanGender(String sex) {
        service.setHumanGender(sex);
    }
}
