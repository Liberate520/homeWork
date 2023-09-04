package ru.gb.Tree.Presenter;


import ru.gb.Tree.Model.Service.Service;
import ru.gb.Tree.View.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addPerson(String name, String gender, LocalDate birthDate, LocalDate deathDate, Integer motherId, Integer fatherId) {
        service.addNewPerson(name, gender, birthDate, deathDate, motherId, fatherId);
        getFamilyTreeInfo();
        service.saveFile();
    }
    public void addPerson(String name, String gender, LocalDate birthDate, Integer motherId, Integer fatherId) {
        service.addNewPerson(name, gender, birthDate, motherId, fatherId);
        getFamilyTreeInfo();
        service.saveFile();
    }

    public void addPerson(String name, String gender, LocalDate birthDate, LocalDate deathDate) {
        service.addNewPerson(name, gender, birthDate, deathDate);
        getFamilyTreeInfo();
        service.saveFile();
    }

    public void addPerson(String name, String gender, LocalDate birthDate, Integer motherId) {
        service.addNewPerson(name, gender, birthDate, motherId);
        getFamilyTreeInfo();
        service.saveFile();
    }

    public void addNewWedding(int firstHumanId, int secondHumanId){
        service.addNewWedding(firstHumanId, secondHumanId);
        service.saveFile();
    }

    public void addNewChild(int parentId, int childId){
        service.addNewChild(parentId, childId);
        service.saveFile();
    }

    public void getFamilyTreeInfo() {
        String info = service.getServiceInfo();
        view.printAnswers(info);
    }

    public void getSavedInfo() {
        view.printAnswers(String.valueOf(service.readFile()));
    }
    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTreeInfo();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getFamilyTreeInfo();
    }
}
