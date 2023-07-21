package Presenter;

import Service.Service;
import UI.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter {
    private Service service;
    private View view;

    public Presenter(Service service, View view) {
        this.service = service;
        this.view = view;
        view.setPresenter(this);
    }

    public String getFamilyTree() {
        return service.getFamilyTree().toString();

    }

    public void addHuman(String status, String name, String surname, LocalDate birthDate, String motherName,
                         String motherSurname, String fatherName, String fatherSurname) {
        service.addHuman(status, name, surname, birthDate, service.getHuman(motherName, motherSurname),
                service.getHuman(fatherName, fatherSurname));
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

    public void sortByName() {
        service.sortByName();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
    }

    public void sortByID() {
        service.sortByID();
    }

    public void removeHuman(String name, String surname) {
        service.removeHuman(name, surname);
    }

    public String getHuman(String name, String surname) {
        return service.getHuman(name, surname).toString();
    }

    public String getStatus(String name, String surname) {
        return service.getStatus(name, surname);
    }

    public LocalDate getBirthDate(String name, String surname) {
        return service.getBirthDate(name, surname);
    }

    public String getMother(String name, String surname) {
        return service.getMother(name, surname).toString();
    }

    public String getFather(String name, String surname) {
        return service.getFather(name, surname).toString();
    }

    public String getChildren(String name, String surname) {
        return service.getChildren(name, surname).toString();
    }

    public boolean containsOf(String name, String surname) {
        return service.containsOf(name, surname);
    }
}
