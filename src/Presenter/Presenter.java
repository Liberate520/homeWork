package Presenter;

import FamilyTree.FamilyTree;
import Human.Human;
import Service.Service;
import UI.View;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;

public class Presenter {
    private Service service;
    private View view;

    public Presenter(Service service, View view) {
        this.service = service;
        this.view = view;
        view.setPresenter(this);
    }

    public FamilyTree getFamilyTree(){
        return service.getFamilyTree();

    }

    public void addHuman(String status, String name, String surname, LocalDate birthDate, Human mother, Human father) {
        service.addHuman(status, name, surname, birthDate, mother, father);
    }

    public void saveChanges() throws IOException {
        service.saveTree();
    }

    public void setStatus(String name, String surname, String newStatus) {
        service.setStatus(name, surname, newStatus);
    }

    public void setName(String name, String surname, String newName) {
        service.setName(name, surname, newName);
    }

    public void setSurname(String name, String surname, String newSurname) {
        service.setSurname(name, surname, newSurname);
    }

    public void setBirthDate(String name, String surname, int year, int month, int day) {
        service.setBirthDate(name, surname, year, month, day);
    }

    public void setMother(String name, String surname, String motherName, String motherSurname) {
        service.setMother(name, surname, motherName, motherSurname);
    }

    public void setFather(String name, String surname, String fatherName, String fatherSurname) {
        service.setFather(name, surname, fatherName, fatherSurname);
    }

    public void sortByName(){
        service.sortByName();
    }

    public void sortByBirthDate(){
        service.sortByBirthDate();
    }

    public void sortByID(){
        service.sortByID();
    }

    public void removeHuman(String name, String surname) {
        service.removeHuman(name, surname);
    }

    public Human getHuman(String name, String surname) {
        return service.getHuman(name, surname);

}

    public String getStatus(String name, String surname) {
        return service.getStatus(name, surname);
    }

    public LocalDate getBirthDate(String name, String surname) {
        return service.getBirthDate(name, surname);
    }

    public Human getMother(String name, String surname) {
        return service.getMother(name, surname);
    }

    public Human getFather(String name, String surname) {
        return service.getFather(name, surname);
    }

    public HashSet<Human> getChildren(String name, String surname) {
        return service.getChildren(name, surname);
    }

}
