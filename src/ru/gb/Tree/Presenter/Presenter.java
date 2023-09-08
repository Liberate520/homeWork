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
    }

    public void addNewWedding(int firstHumanId, int secondHumanId){
        service.addNewWedding(firstHumanId, secondHumanId);
    }

    public void addNewChild(int parentId, int childId){
        service.addNewChild(parentId, childId);
    }

    public void getHumanList() {
        view.printAnswers(service.getHumanInfo());
    }

    public void sortByAge() {
        service.sortByAge();

    }

    public void sortByName() {
        service.sortByName();

    }

    public void sortByBirthDate() {
        service.sortByBirthDate();

    }
}
